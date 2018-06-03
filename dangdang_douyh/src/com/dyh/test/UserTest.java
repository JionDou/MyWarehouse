package com.dyh.test;

import com.dyh.entity.User;
import com.dyh.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {

	@Test
	public void queryUserByEmailAndPasswordTest() {
		UserServiceImpl usi = new UserServiceImpl ();
		User user = usi.queryUserByEmailAndPassword("1819215878@qq.com", "123456");
		System.out.println("queryUserByEmailAndPasswordTest"+user);
	}
}
