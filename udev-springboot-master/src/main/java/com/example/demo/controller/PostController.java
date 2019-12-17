package com.example.demo.controller;

import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.PostJSON;
import com.example.demo.service.AuthService;
import com.example.demo.service.BookService;
import com.example.demo.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = {"Post"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Resource
    private PostService postService;

   // @Resource
   // private AuthService authService;

    @ApiOperation(value = "Get all Posts")
    @RequestMapping(method = RequestMethod.GET)
    public List<PostJSON> getAll() {
        return postService.getAllPosts();
    }


}
