package com.jt.demo.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jt.demo.mapper.UserMapper;
import com.jt.demo.pojo.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMybatis {
	
	@Resource
	private UserMapper userMapper;
	
	@Test
	public void testFindUser() {
		
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
	}
}
