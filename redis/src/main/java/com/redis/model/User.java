package com.redis.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String name;
	private String email;
	private String phone;
}
