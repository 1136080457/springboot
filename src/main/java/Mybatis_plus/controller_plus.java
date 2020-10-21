package Mybatis_plus;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

@RestController
public class controller_plus {

	/**
	 * 无需xml映射文件，可以直接使用封装好的crud方法
	 * EntityWrapper条件构造器
	 * 
	 */
	
	
	@Autowired
	private OneMapper mapper;
	@Autowired
	private SecondMapper semapper;
	
	
	@RequestMapping("save")
	public void save() throws InstantiationException, IllegalAccessException {
		entity e = new entity();
		
		e.setCode("1");
		e.setCreate(new Date());
		e.setEdit(new Date());
		e.setName("hjj");
		e.setStatus('A');
		Integer i = mapper.insert(e);
		
	}
	
	@RequestMapping("select")
	public String select() {
		List<entity> l = mapper.selectList(new EntityWrapper<entity>().eq("name", "hjj"));
		StringBuffer sb = new StringBuffer();
		l.forEach(n-> sb.append(n.toString()));
		return sb.toString();
	}
	
	
	
	@RequestMapping("delete")
	public Integer delete() {
		entity e = new entity();
		
		e.setCode("1");
		
		e.setName("hjj");
		e.setStatus('A');
		return mapper.delete(new EntityWrapper<entity>(e));
	}
	
	@RequestMapping("se")
	public String select1() {
		//使用条件构造器，条件查询
		Wrapper<entity> w = new EntityWrapper<entity>();
		w.where("id={0}", "1");
		
		List<entity> l = mapper.selectList(w);
		String s = null;
		for(entity e : l) {
			s+=e.toString();
		}
		return s;
	}
	
	@RequestMapping("page")
	public String pageSelect() {
		//分页查询
		Wrapper<entity> wrapper = new EntityWrapper<>();
		List<entity> l = mapper.selectPage(new RowBounds(0, 2), wrapper);
		String s = null;
		for(entity e : l) {
			s+=e.toString();
		}
		return s;
	}
	
	@RequestMapping("second")
	public String secondMapper() {
		entity2 e = new entity2();
		e.setId(1);
		entity2 ee = semapper.selectById(e.getId());
		return ee.toString();
	}
}
