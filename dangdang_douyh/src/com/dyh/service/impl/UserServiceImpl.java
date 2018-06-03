package com.dyh.service.impl;

import com.dyh.dao.UserMapper;
import com.dyh.entity.User;
import com.dyh.service.UserService;
import com.dyh.util.MyBatisUtil;

public class UserServiceImpl implements UserService {
	
	@Override//用户的登录，通过邮箱和密码
	public User queryUserByEmailAndPassword(String email, String password) {
		User userLogin = null;
		try {
			UserMapper userMapper = (UserMapper) MyBatisUtil.getMapper(UserMapper.class);//获取userDao的实现类对象
		    userLogin = userMapper.selectOneUserByEmailAndPassword(email, password);//调用根据邮箱和密码来查询的方法，实现登录查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("登录查询失败");
		}
		return userLogin;//返回一个User
	}

	@Override//用户的注册第一步
	public void addUserFirst(User user) {
		try {
			UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);//获取userDao的实现类对象
			userMapper.insertUserfirst(user);							//调用注册1方法，实现注册第一步
			MyBatisUtil.commit();//事务的提交
		} catch (Exception e) {
			MyBatisUtil.rollback();//事务的回滚
			e.printStackTrace();
			throw new RuntimeException("用户注册第一步失败");
		}
		
	}

	@Override//根据用户的邮箱来修改用户的状态
	public void ModifyUser(String email) {
		try {
			UserMapper userMapper = MyBatisUtil.getMapper(UserMapper.class);//获取userDao的实现类对象
			userMapper.updateUserStaus(email);//实现修改功能
			MyBatisUtil.commit();                //事物的提交
			
		} catch (Exception e) {
			MyBatisUtil.rollback();//事务的回滚
			e.printStackTrace();
			throw new RuntimeException("用户的状态修改失败");
		}
		
	}

}
