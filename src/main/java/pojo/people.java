package pojo;

import java.io.Serializable;
import java.math.BigDecimal;


public class people implements Serializable{
	
	private Integer id;
	private BigDecimal idcard;
	private String name;
	private Integer age;
	private Integer sex;
	private Integer money;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getIdcard() {
		return idcard;
	}
	public void setIdcard(BigDecimal idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	} 
}
