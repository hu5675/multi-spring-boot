package com.mars.bootweb;

import com.mars.exception.GlobalException;
import com.mars.model.User;
import com.mars.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class, locations = {"classpath*:application.yml"})
public class BootWebApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void testInsertUser() throws GlobalException {
		User user = new User();
		user.setUserName("事务测试1");
		user.setDescription("事务测试1_描述");

		this.userService.inserUser(user);
	}

}
