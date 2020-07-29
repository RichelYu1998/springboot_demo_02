package cn.tedu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")//将对象与表名关联 如果对象名称与表名一致则可以省略不写
public class User {
	@TableId(type = IdType.AUTO)// 定义主键信息 自增
	private Integer id;
	//@TableField(value = "name")  //标识字段与属性的关联关系
	private String name;
	private Integer age;
	private String sex;

}
