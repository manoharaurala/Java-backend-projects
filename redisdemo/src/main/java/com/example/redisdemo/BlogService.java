package com.example.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BlogService {

    private static String prefix="blog_";
    private String nextIdKey="nextId";

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    public Long createBlog(Blog blog){
        Long id=redisTemplate.opsForValue().increment(nextIdKey);
        String key=prefix+id;

        redisTemplate.opsForValue().set(key,blog);

        return id;

    }

    public Blog getBlog(Long id){
        String key=prefix+id;
        Blog blog= (Blog) redisTemplate.opsForValue().get(key);
        return blog;
    }


}
