package com.github.easilyuse.example.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.easilyuse.example.EasilyHttpExampleApplication;
import com.github.easilyuse.example.client.UserHttpClient;
import com.github.easilyuse.example.dto.UserDTO;
import com.github.easilyuse.example.model.User;

@SpringBootTest(classes = { EasilyHttpExampleApplication.class })
@RunWith(SpringRunner.class)
public class UserHttpClientTest {

	@Autowired
	private UserHttpClient userHttpClient;

	@Test
	public void testLogin() {
		UserDTO userDTO = UserDTO.builder().name("张三").password("zhangsan").build();

		User user = userHttpClient.login(userDTO);

		Assert.assertNotNull(user.getId());
	}

	@Test
	public void testDeleteUserById() {

		boolean isDelete = userHttpClient.deleteUserById(1L);

		Assert.assertTrue(isDelete);
	}

	@Test
	public void testSaveUser() {

		UserDTO userDTO = UserDTO.builder().name("李雷").password("韩梅梅").sex("男").age(25).build();

		long id = userHttpClient.saveOrUpdateUser(userDTO);

		Assert.assertEquals(6L, id);
	}

	@Test
	public void testUpdateUser() {

		UserDTO userDTO = new UserDTO();

		User user = userHttpClient.findUserById(1L);

		BeanUtils.copyProperties(user, userDTO);

		userDTO.setPassword("123456");

		long id = userHttpClient.saveOrUpdateUser(userDTO);

		Assert.assertEquals(user.getId().longValue(), id);
	}

	@Test
	public void testListPage() {
		UserDTO userDTO = new UserDTO();
		// userDTO.setAge(25);
		// userDTO.setId(2L);
		// userDTO.setName("李四");
		userDTO.setSex("男");

		List<User> users = userHttpClient.listPage(userDTO, 1, 5);

		users.forEach(user -> System.out.println(user));
	}
}
