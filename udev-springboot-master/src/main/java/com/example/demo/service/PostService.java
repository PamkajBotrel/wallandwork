package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j  //bibliothèque pour les log
@Service
public class PostService {
    @Resource
    private PostRepository postRepository;

    @Resource
    private Mapper mapper;

    public List<PostJSON> getAllPosts() {
        log.info("Called for getAllPosts ...");
        List<Post> postList = postRepository.findAll();
        return mapper.mapToPost(postList);
    }






}
