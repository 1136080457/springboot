package springboot_1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@EnableCaching  //开启单机redis缓存
@Controller
//@EnableScheduling//开启定时任务
//@EnableTransactionManagement//开启事务管理
@MapperScan({"pojo","Mybatis_plus"})   
@SpringBootApplication(scanBasePackages={"pojo","springboot_1","redis","Mybatis_plus"},exclude=DataSourceAutoConfiguration.class)    //扫描包,(本类下可以不用写,本包非此类下也要写)
public class app {  					       //application.properties和yml的区别：properties格式是 xx=xx;yml格式是xx: xx(注意有一个空格),且直接支持中文
								//在页面中请求时,用findbyid/{id}的方式，页面或方法的地址格式相同即可，即：findbyid/{},括号里的内容不在乎
	public static void main(String[] args) {
		
		SpringApplication.run(app.class, args);

	}
	
	@GetMapping("index")   //注意：1.访问地址不要和返回的结果视图名字一样，会出错;2.@Controller是返回结果视图,而@RestController返回的是json字符串
	public String login() {
		
		return "login.html";
	}
	
	
	
}
