package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redis.dao.UserDao;
import com.redis.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao dao;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user){
		return new ResponseEntity<>(dao.save(user),HttpStatus.OK);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestParam String userid){
		return new ResponseEntity<>(dao.get(userid),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		return new ResponseEntity<>(dao.update(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")	
	public ResponseEntity<String> deleteUser(@RequestParam String userid){
		dao.delete(userid);
		return new ResponseEntity<String>("User deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
	}
	
}