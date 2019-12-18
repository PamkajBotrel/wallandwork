package com.example.demo.controller;

import com.example.demo.pojo.WallMessageJSON;
import com.example.demo.service.WallMessageService;
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
@Api(tags = {"WallMessage"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "wallMessages", produces = MediaType.APPLICATION_JSON_VALUE)
public class WallMessageController {
    @Resource
    private WallMessageService wallMessageService;

   // @Resource
   // private AuthService authService;

    @ApiOperation(value = "Get all WallMessages")
    @RequestMapping(method = RequestMethod.GET)
    public List<WallMessageJSON> getAll() {
        return wallMessageService.getAllWallMessages();
    }
    
    @ApiOperation(value = "Get one WallMessage", response = WallMessageJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public WallMessageJSON getWallMessageById(@ApiParam(value = "WallMessage id", required = true) @PathVariable long id) {
        return wallMessageService.getWallMessageById(id);
    }

   /*@PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }*/
   @ApiOperation(value = "Add WallMessage", response = WallMessageJSON.class)
   @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.CREATED)
   public WallMessageJSON addWallMessage(//@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                                  @ApiParam(value = "WallMessage to Add", required = true) @Valid @RequestBody WallMessageJSON wallMessage) {
       // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
       // or JPA RollbackException (DB side)
       /*if (!authService.isAuthorize(authorization)) {
           throw new ForbiddenException();
       }*/
       return wallMessageService.addWallMessage(wallMessage);
   }

    
}
