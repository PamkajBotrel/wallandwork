package com.example.demo.controller;

import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.pojo.BookJSON;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.BookService;
import com.example.demo.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;
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
    
    @ApiOperation(value = "Get one Post", response = PostJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public PostJSON getPost(@ApiParam(value = "Post id", required = true) @PathVariable long id) {
        return postService.getPostById(id);
    }

   /*@PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }*/
   @ApiOperation(value = "Add Post", response = PostJSON.class)
   @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.CREATED)
   public PostJSON addPost(//@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                           @ApiParam(value = "Post to Add", required = true) @Valid @RequestBody PostJSON post) {
       // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
       // or JPA RollbackException (DB side)
       /*if (!authService.isAuthorize(authorization)) {
           throw new ForbiddenException();
       }*/
       return postService.addPost(post);
   }

    
}
