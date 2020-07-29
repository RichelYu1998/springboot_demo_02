package cn.tedu.test;

import java.util.List;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	//案例1.利用MP查询所有的数据
	@Test
	public void selectList(){
		List<User> userList = userMapper.selectList(null);
		System.out.println(userList);
	}
	//1.用户入库操作
	//注意：MP操作时，将对象中不为null的数据当做执行操作
	@Test
	public void insert(){
		User user = new User();
		user.setName("特朗普");
		user.setAge(60);
		user.setSex("男");
		userMapper.insert(user);
		System.out.println("入库成功");
	}
}
