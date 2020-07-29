package cn.tedu.mapper;

import java.util.List;

import cn.tedu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
	
	List<User> findAll();
}
