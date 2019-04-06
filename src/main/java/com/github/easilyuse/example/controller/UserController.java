package com.github.easilyuse.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.easilyuse.example.dto.UserDTO;
import com.github.easilyuse.example.model.User;
import com.github.easilyuse.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/u")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public User login(UserDTO userDTO) {
		log.info("{}", userDTO);
		return userService.login(userDTO);
	}

	@RequestMapping(value = "/findUserById")
	public User findUserById(Long id) {
		log.info("{}", id);
		return userService.findUserById(id);
	}

	@RequestMapping(value = "/saveOrUpdateUser")
	public Long saveOrUpdateUser(@RequestBody UserDTO userDTO) {
		log.info("{}", userDTO);
		return userService.saveOrUpdateUser(userDTO);
	}

	@RequestMapping(value = "/listPage")
	public List<User> listPage(@ModelAttribute UserDTO userDTO, int pageNo, int pageSize) {
		log.info("userDTO:{},pageNo:{},pageSize:{}", userDTO, pageNo, pageSize);
		return userService.listPage(userDTO, pageNo, pageSize);
	}

	@RequestMapping(value = "/deleteUserById")
	public boolean deleteUserById(Long id) {
		log.info("{}", id);
		return userService.deleteUserById(id);
	}
}
