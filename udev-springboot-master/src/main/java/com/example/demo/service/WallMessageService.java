package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.WallMessage;
import com.example.demo.pojo.WallMessageJSON;
import com.example.demo.repository.WallMessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j  //bibliothèque pour les log
@Service
public class WallMessageService {
    @Resource
    private WallMessageRepository wallMessageRepository;

    @Resource
    private Mapper mapper;

    public List<WallMessageJSON> getAllWallMessages() {
        log.info("Called for getAllWallMessages ...");
        List<WallMessage> wallMessageList = wallMessageRepository.findAll();
        return mapper.mapToPost(wallMessageList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "wallMessages", key = "#id")
    public WallMessageJSON getWallMessageById(long id) {
        log.info("Called for getPostById ...");
        WallMessage p = wallMessageRepository.getOne(id);
        return mapper.mapToPost(p);
    }

    public WallMessageJSON addWallMessage(WallMessageJSON wallMessage) {
        WallMessage wm = wallMessageRepository.save(mapper.mapToPost(wallMessage));
        return mapper.mapToPost(wm);
    }
}
