package com.github.easilyuse.example.service;

import java.util.List;

import com.github.easilyuse.example.dto.UserDTO;
import com.github.easilyuse.example.model.User;

public interface UserService {

	User login(UserDTO userDTO);

	User findUserById(Long id);

	Long saveOrUpdateUser(UserDTO userDTO);

	List<User> listPage(UserDTO userDTO, int pageNo, int pageSize);

	boolean deleteUserById(Long id);

}
