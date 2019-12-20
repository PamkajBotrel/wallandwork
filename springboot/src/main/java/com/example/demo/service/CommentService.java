package com.example.demo.service;

import com.example.demo.helper.CommentMapper;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import com.example.demo.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j // bibliothèque pour les log
@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentMapper mapper;

    public List<CommentJSON> getAllComments() {
        log.info("Called for getAllComments ...");
        List<Comment> commentList = commentRepository.findAll();
        return mapper.mapTo(commentList);
    }

    public List<CommentJSON> getAllCommentsFromWallMessageId(long wallMessageId) {
        log.info("Called for getAllCommentsFromWallMessageId");
        List<Comment> commentList = commentRepository.findAllCommentsFromWallMessageId(wallMessageId);
        return mapper.mapTo(commentList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "comments", key = "#id")
    public CommentJSON getCommentById(long id) {
        log.info("Called for getPostById ...");
        Comment c = commentRepository.getOne(id);
        return mapper.mapTo(c);
    }

    public CommentJSON addComment(CommentJSON comment) {
        Comment c = mapper.mapTo(comment);
        c = commentRepository.save(c);
        return mapper.mapTo(c);
    }

    public int updateComment(CommentJSON comment) {
        int numrows = commentRepository.setFixedContentFor(comment.getId(), comment.getContent());
        return numrows;
    }

    public CommentJSON delete(CommentJSON comment) {
        Optional<Comment> comment$ = commentRepository.findById(comment.getId());
        System.out.println("deleting a comment");
		if(comment$.isPresent()){
            
            commentRepository.delete(comment$.get());
        }
        return mapper.mapTo(comment$.get());
	}
}