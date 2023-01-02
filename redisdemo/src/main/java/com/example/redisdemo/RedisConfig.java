package com.example.redisdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
  /*  @Value("${redis.url}")
    private String redisUrl;

    @Bean
    public RedisConnectionFactory getRedisConnectionFactory() {


        String host = "redis-15278.c57.us-east-1-4.ec2.cloud.redislabs.com";
        String password ="HTI5boZIx8nXu0U8ANq4zzDEhaCTrZ75";
        int port = 15278;
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        lettuceConnectionFactory.setHostName(host);
        lettuceConnectionFactory.setPort(port);
        lettuceConnectionFactory.setPassword(password);
        return lettuceConnectionFactory;


    }*/

    @Bean
    RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        return  redisTemplate;


    }
}
