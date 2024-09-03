package com.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory getConnectionFactory() {
		
		return new LettuceConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplet(){
		
		RedisTemplate<String, Object> redisTemplet = new RedisTemplate<>();
		
		// connection factory
		redisTemplet.setConnectionFactory(getConnectionFactory());
		// key serialization 
		redisTemplet.setKeySerializer(new StringRedisSerializer());
		// value serialization
		redisTemplet.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		
		return redisTemplet;
		
		
		
	}
}
