package springboot_1;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



//@Controller
@Component
public class test {

	
	@Autowired
	@Value("${springboot_1.name}")  //获取自定义的参数
	public String name;
	
	@RequestMapping("dudu")
	public String dudu() throws SQLException{
		
		return name;
	}
	
	@Scheduled(fixedRate = 3000)
	@ResponseBody
	@RequestMapping("/time")
	public String time() {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(date);
		return date;
	}
	
}
