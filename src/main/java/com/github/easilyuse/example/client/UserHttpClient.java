package com.github.easilyuse.example.client;

import java.util.List;

import com.github.easilyuse.core.annotation.HttpClient;
import com.github.easilyuse.core.annotation.HttpReqBean;
import com.github.easilyuse.core.annotation.HttpReqMethod;
import com.github.easilyuse.core.annotation.HttpReqParam;
import com.github.easilyuse.core.enu.HttpMethod;
import com.github.easilyuse.core.enu.MimeType;
import com.github.easilyuse.example.dto.UserDTO;
import com.github.easilyuse.example.model.User;

@HttpClient(url = "http://localhost:8080")
public interface UserHttpClient {

	@HttpReqMethod(path = "/u/login", HTTP_METHOD = HttpMethod.GET)
	User login(@HttpReqBean UserDTO userDTO);

	@HttpReqMethod(path = "/u/findUserById")
	User findUserById(@HttpReqParam("id") Long id);

	@HttpReqMethod(path = "/u/saveOrUpdateUser", HTTP_METHOD = HttpMethod.POST, contentType = MimeType.APPLICATION_JSON)
	Long saveOrUpdateUser(@HttpReqBean UserDTO userDTO);

	@HttpReqMethod(path = "/u/listPage", HTTP_METHOD = HttpMethod.POST, expectReturnType = User.class)
	List<User> listPage(@HttpReqBean UserDTO userDTO, @HttpReqParam("pageNo") int pageNo,
			@HttpReqParam("pageSize") int pageSize);

	@HttpReqMethod(path = "/u/deleteUserById")
	boolean deleteUserById(@HttpReqParam("id") Long id);

}
