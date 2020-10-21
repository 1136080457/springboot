package pojo;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

@Service
public interface  dao {

	
	public List<people> findall_dao();//查询所有，返回list
	public Map<String, Object> findbyid(int id);//按id查询，返回map
	
}
