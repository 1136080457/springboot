package Excel;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@Setter
@Getter
@TableName("order")
public class pojo {

	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String f;
	private String g;
	private String h;
	private String i;
	private String j;
	private String k;
	private String l;
	
}
