package com.dyh.dao;

import com.dyh.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	User selectOneUserByEmailAndPassword(@Param("email") String email,
										 @Param("password") String password);//通过邮箱和密码来查询一个
	void insertUserfirst(User user);   				   //用户的注册
	void updateUserStaus(@Param("email") String email);//根据邮箱来修改用户状态
}
