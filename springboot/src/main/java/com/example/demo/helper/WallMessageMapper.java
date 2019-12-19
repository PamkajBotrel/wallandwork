package com.example.demo.helper;

import com.example.demo.pojo.WallMessage;
import com.example.demo.pojo.WallMessageJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WallMessageMapper {

    public WallMessage mapToPost(WallMessageJSON wallMessageJSON) {
        Assert.notNull(wallMessageJSON, "The wallMessageJSON must not be null");
        WallMessage wm = new WallMessage();
        // must not set id !
        wm.setTitle(wallMessageJSON.getTitle());
        wm.setContent(wallMessageJSON.getContent());
        wm.setCreatedAt(wallMessageJSON.getCreatedAt());
        wm.setUpdatedAt(wallMessageJSON.getUpdatedAt());
        wm.setAuthorId(wallMessageJSON.getAuthorId());
        return wm;
    }

    public WallMessageJSON mapToPost(WallMessage wallMessage) {
        Assert.notNull(wallMessage, "The wallMessage must not be null");
        WallMessageJSON wmJSON = new WallMessageJSON();
        wmJSON.setId(wallMessage.getId());
        wmJSON.setTitle(wallMessage.getTitle());
        wmJSON.setContent(wallMessage.getContent());
        wmJSON.setCreatedAt(wallMessage.getCreatedAt());
        wmJSON.setUpdatedAt(wallMessage.getUpdatedAt());
        wmJSON.setAuthorId(wallMessage.getAuthorId());
        return wmJSON;
    }

    public List<WallMessageJSON> mapToPost(List<WallMessage> wallMessageList) {
        Assert.notNull(wallMessageList, "The wallMessageList must not be null");
        return wallMessageList.stream().map(this::mapToPost).collect(Collectors.toList());
    }
}
