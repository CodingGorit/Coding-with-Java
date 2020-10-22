package cn.gorit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    //会从上下文中自动注入redisConnectionFactory
    public RedisTemplate<Object, Object> redisTemplate(LettuceConnectionFactory connectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        //设置key,value的序列化   默认序列化是Jdk
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        //将序列化的对象转成json的序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
}
