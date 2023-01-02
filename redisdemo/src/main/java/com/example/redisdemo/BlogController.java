package com.example.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private String  VisitorQueueKey="Visitor_Queue";

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    BlogService blogService;
    @PostMapping
    public ResponseEntity<Long> createBlog(@RequestBody Blog blog){
       Long id= blogService.createBlog(blog);
       return ResponseEntity.ok(id);
    }

    @PostMapping("/addVisitor")
    public ResponseEntity<Long> addVisitor(@RequestParam String namr){
        long size=redisTemplate.opsForList().leftPush(VisitorQueueKey,namr);
        return ResponseEntity.ok(size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id){
        Blog blog=blogService.getBlog(id);
        return ResponseEntity.ok(blog);
    }
}
