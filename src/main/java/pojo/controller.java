package pojo;


import java.util.List;
import java.util.Map;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class controller {

	@Autowired 
	private serviceimp s;
	
	@GetMapping("find_all")
	public List<people> find_all() {
		List<people> ll = s.findall_service();
		return ll;
	}
	
	@RequestMapping("findbyid/{i}")
	public Map<String, Object> findbyid(@RequestParam(value="id")int id){
		
		return s.findbyid_service(id);
	}
	
	
	@Autowired
	private peopleMapper p;
	
	@RequestMapping("findall")
	//@Cacheable(value="key_findall")  
	//放入单机redis缓存中，下一次访问的时候，不会执行此方法，从缓存中取
	public List<people> findall(){
		//这里是集成的mybatis
		System.out.println("使用了redis了吗？");
		return p.findall();
	}
	
	//@Cacheable(value="findd")
	@RequestMapping("findd")
	public Set<people> findd(){
		
		return p.findd();
	}
}
