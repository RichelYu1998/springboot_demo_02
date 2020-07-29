package cn.tedu.test;

import java.util.List;

import cn.tedu.mapper.UserMapper;
import cn.tedu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
	//只可以操作"="的要求
	@Test
	public void insert(){
		User user = new User();
		user.setName("特朗普");
		user.setAge(60);
		user.setSex("男");
		userMapper.insert(user);
		System.out.println("入库成功");
	}
	//2.用户查询操作
	//2.1查询name="特朗普"的用户
	@Test
	public void select01(){
		//定义条件构造器 动态拼接where条件之后的数据
		User user = new User();
		user.setName("特朗普");
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.2查询sex="女" age>200的用户
	//逻辑运算符 =eq,>gt,<lt,>=ge,<=le
	@Test
	public void select02(){
		//定义条件构造器 动态拼接where条件之后的数据
		User user = new User();
		//user.setAge(200);//等于
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.eq("sex","女");
		queryWrapper.gt("age","200");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.3查询name包含"精"的用户 like
	@Test
	public void select03(){
		//定义条件构造器 动态拼接where条件之后的数据
		User user = new User();
		//user.setAge(200);//等于
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.like("name","精");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.3用户查询操作
	//查询name包含"精"的用户 like
	@Test
	public void select04(){
		//定义条件构造器 动态拼接where条件之后的数据
		User user = new User();
		//user.setAge(200);//等于
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.likeLeft("name","精");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
}
