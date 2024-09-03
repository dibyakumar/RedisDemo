package com.redis.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

import com.redis.model.User;

@Repository
public class UserDao {
	/*
	 *  we will perform hash-operation 
	 *  for that we need 
	 *  
	 *  Key [key value ....]
	 */
	@Autowired
	private RedisTemplate<String, Object> redisTemplet;
	// this is the key for the hash 	
	private final String KEY = "USER";
	
	public User save(User user) {
		redisTemplet.opsForHash().put(KEY, user.getUserId(),user);
		return user;
	}
	
	public User get(String userId) {
		return (User)redisTemplet.opsForHash().get(KEY, userId);
	}
	
	public Map<Object, Object> getAll(){
	return redisTemplet.opsForHash().entries(KEY);
	}
	
	public void delete(String userId) {
		redisTemplet.opsForHash().delete(KEY, userId);
	}
	
	public User update(User user) {
		redisTemplet.opsForHash().put(KEY, user.getUserId(), user);
		return user;
	}
}
