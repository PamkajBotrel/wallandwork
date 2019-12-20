package com.example.demo.helper;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CommentMapper {

    public Comment mapTo(CommentJSON commentJSON) {
        Assert.notNull(commentJSON, "The commentJSON must not be null");
        Comment c = new Comment();
        // must not set id !
        c.setWallMessageId(commentJSON.getWallMessageId());
        c.setTitle(commentJSON.getTitle());
        c.setContent(commentJSON.getContent());
        c.setCreatedAt(commentJSON.getCreatedAt());
        c.setUpdatedAt(commentJSON.getUpdatedAt());
        c.setAuthorId(commentJSON.getAuthorId());
        return c;
    }

    public CommentJSON mapTo(Comment comment) {
        Assert.notNull(comment, "The comment must not be null");
        CommentJSON cJSON = new CommentJSON();
        cJSON.setId(comment.getId());
        cJSON.setWallMessageId(comment.getWallMessageId());
        cJSON.setTitle(comment.getTitle());
        cJSON.setContent(comment.getContent());
        cJSON.setCreatedAt(comment.getCreatedAt());
        cJSON.setUpdatedAt(comment.getUpdatedAt());
        cJSON.setAuthorId(comment.getAuthorId());
        return cJSON;
    }

    public List<CommentJSON> mapTo(List<Comment> commentList) {
        Assert.notNull(commentList, "The commentList must not be null");
        return commentList.stream().map(this::mapTo).collect(Collectors.toList());
    }

}