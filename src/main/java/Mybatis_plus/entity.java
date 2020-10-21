package Mybatis_plus;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Setter
@Getter
@TableName("user")
public class entity{

	@TableId(type = IdType.AUTO,value = "id")
	private int id;
	@TableField("code")
	private String code;
	@TableField("name")
	private String name;
	@TableField("status")
	private char status;
	@TableField("gmt_create")
	private Date create;
	@TableField("gmt_modified")
	private Date edit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getEdit() {
		return edit;
	}
	public void setEdit(Date edit) {
		this.edit = edit;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", code=" + code + ", name=" + name + ", status=" + status + ", create=" + create
				+ ", edit=" + edit +"]";
	}
	
	
}
