package cn.tedu.test;

import java.util.ArrayList;
import java.util.Arrays;
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
		User user = new User();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.eq("sex","女");
		queryWrapper.gt("age","200");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.3查询name包含"精"的用户 like
	@Test
	public void select03(){
		User user = new User();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.like("name","精");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.4查询name包含"精"的用户 like
	@Test
	public void select04(){
		User user = new User();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.likeLeft("name","精");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.5查询age位于 18-35 and 性别="男" 的用户 between
	@Test
	public void select05(){
		User user = new User();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.between("age",18,35)
		.eq("sex","男");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.6查询name不为null的用户信息，并根据age进行降序排列，如果age相同按sex排序
	@Test
	public void select06(){
		User user = new User();
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		queryWrapper.isNotNull("name")
		.orderByDesc("age","sex");
		List<User> userList = userMapper.selectList(queryWrapper);
		System.out.println(userList);
	}
	//2.7根据主键查询 返回单个对象
	@Test
	public void select07(){
		User user = userMapper.selectById(1);
		System.out.println(user);
	}
	/*//2.8根据非主键查询 返回单个对象
	@Test
	public void select08(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name","特朗普");
	}*/
	//2.9批量查询数据
	@Test
	public void select09(){
		/*List<Integer> idList = new ArrayList<>();*/
		/*idList.add(1);
		idList.add(3);
		idList.add(5);
		idList.add(8);*/
		//一般为数组格式
		Integer[] ids={1,3,5,8};
		List<Integer> list2= Arrays.asList(ids);
		List<User> userList = userMapper.selectBatchIds(list2);
		System.out.println(userList);
	}
	//2.10查询name不为null记录总数
	@Test
	public void select10(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.isNotNull("name");
		Integer count = userMapper.selectCount(queryWrapper);
		System.out.println(count);
	}
	//2.用户删除操作
	//2.1删除id="53"的用户
	@Test
	public void delete(){
		int id = userMapper.deleteById(53);
		System.out.println(id);
	}
}
