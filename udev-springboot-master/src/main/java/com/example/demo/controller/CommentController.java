package com.example.demo.controller;

import com.example.demo.pojo.CommentJSON;
import com.example.demo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = { "Comment" })
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    @Resource
    private CommentService commentService;

    // @Resource
    // private AuthService authService;

    @ApiOperation(value = "Get all Comments")
    @RequestMapping(method = RequestMethod.GET)
    public List<CommentJSON> getAll() {
        return commentService.getAllComments();
    }
        
    @ApiOperation(value = "Get one Comment", response = CommentJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public CommentJSON getCommentById(@ApiParam(value = "Comment id", required = true) @PathVariable long id) {
        return commentService.getCommentById(id);
    }

   /*@PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }*/
   @ApiOperation(value = "Add Comment", response = CommentJSON.class)
   @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.CREATED)
   public CommentJSON addComment(//@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                                  @ApiParam(value = "Comment to Add", required = true) @Valid @RequestBody CommentJSON comment) {
                                    // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
       // or JPA RollbackException (DB side)
       /*if (!authService.isAuthorize(authorization)) {
           throw new ForbiddenException();
       }*/
       return commentService.addComment(comment);
   }

   @ApiOperation(value = "Update Comment", response = CommentJSON.class)
   @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update") // URL !!
   @ResponseStatus(HttpStatus.CREATED)
   public int updateComment(//@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                                  @ApiParam(value = "Comment to Update", required = true) @Valid @RequestBody CommentJSON comment) {
                                    // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
       // or JPA RollbackException (DB side)
       /*if (!authService.isAuthorize(authorization)) {
           throw new ForbiddenException();
       }*/
       return commentService.updateComment(comment);
   }
    
   @ApiOperation(value = "Get all comments from a WallMessage", response = CommentJSON.class)
   @RequestMapping(method = RequestMethod.GET, value = "wallmessage/{id}")
   public List<CommentJSON> getAllCommentsFromWallMessageId(@ApiParam(value = "WallMessage id", required = true) @PathVariable long id) {
       return commentService.getAllCommentsFromWallMessageId(id);
   }

}
