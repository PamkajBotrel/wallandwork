package com.example.demo.controller;

import com.example.demo.pojo.MemberJSON;
import com.example.demo.service.MemberService;
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
@Api(tags = {"Member"})
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "member", produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController {
    @Resource
    private MemberService memberService;

   // @Resource
   // private AuthService authService;

    @ApiOperation(value = "Get all Members")
    @RequestMapping(method = RequestMethod.GET)
    public List<MemberJSON> getAll() {
        return memberService.getAllMembers();
    }
    
    @ApiOperation(value = "Get one Member", response = MemberJSON.class)
    @GetMapping(value = "{id}")
    public MemberJSON getMemberById(@ApiParam(value = "Member id", required = true) @PathVariable long id) {
        return memberService.getMemberJSONById(id);
    }

   /*@PostMapping("/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }*/
   @ApiOperation(value = "Add Member", response = MemberJSON.class)
   @PostMapping(headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.CREATED)
   public MemberJSON addMember(//@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") String authorization,
                                  @ApiParam(value = "Member to Add", required = true) @Valid @RequestBody MemberJSON member) {
       // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
       // or JPA RollbackException (DB side)
       /*if (!authService.isAuthorize(authorization)) {
           throw new ForbiddenException();
       }*/
       return memberService.addMember(member);
   }


    @GetMapping(value = "/email/{email}")
    // FIXME not good path for REST ...
    public long findIfMailInDataBase(@ApiParam(value = "Email", required = true) @PathVariable String email) {
        return memberService.getIfEmailInDatabase(email);
    }


}


