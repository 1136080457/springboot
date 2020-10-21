package Mybatis_plus;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("emp")
public class entity2 {

	@TableField("name")
	private String name;
	
	@TableField("age")
	private int age;
	
	@TableField("id")
	private int id;
	
	@TableField("salary")
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "entity2 [name=" + name + ", age=" + age + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
	
}
