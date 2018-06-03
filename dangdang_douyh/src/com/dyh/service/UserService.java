package com.dyh.service;

import com.dyh.entity.User;

public interface UserService {
	User queryUserByEmailAndPassword(String email, String password);//通过用户邮箱和密码来查询
	void addUserFirst(User user);                                  //用户的注册第一步
	void ModifyUser(String email);                                //根据用户的邮箱来修改用户的状态
}
