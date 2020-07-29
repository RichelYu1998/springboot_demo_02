package cn.tedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("user")	//将对象与表名关联  如果对象名称与表名一致 则可以省略不写.
@Accessors(chain = true)
public class User {
	@TableId(type = IdType.AUTO)	//定义主键信息  主键自增.
	private Integer id;
	//@TableField(value = "name")	//表示字段与属性的关联关系
	private String name;
	private Integer age;
	private String sex;

}
