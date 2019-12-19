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

@Slf4j  //bibliothèque pour les log
@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentMapper commentMapper;

    public List<CommentJSON> getAllComments() {
        log.info("Called for getAllComments ...");
        List<Comment> commentList = commentRepository.findAll();
        return commentMapper.mapTo(commentList);
    }

    public List<CommentJSON> getAllCommentsFromWallMessageId(long wallMessageId) {
        log.info("Called for getAllCommentsFromWallMessageId");
        List<Comment> commentList = commentRepository.findAllCommentsFromWallMessageId(wallMessageId);
        return commentMapper.mapTo(commentList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "comments", key = "#id")
    public CommentJSON getCommentById(long id) {
        log.info("Called for getPostById ...");
        Comment p = commentRepository.getOne(id);
        return commentMapper.mapTo(p);
    }

    public CommentJSON addComment(CommentJSON comment) {
        Comment wm = commentRepository.save(commentMapper.mapTo(comment));
        return commentMapper.mapTo(wm);
    }

    public int updateComment(CommentJSON comment) {
        int numrows = commentRepository.setFixedContentFor(comment.getId(),comment.getContent());
        return numrows;
    }
}