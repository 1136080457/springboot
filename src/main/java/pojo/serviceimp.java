package pojo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceimp implements service{

	@Autowired
	private daoimp d;
	

	public List<people> findall_service() {
		List<people> l = d.findall_dao();
		return l;
	}

	public Map<String, Object> findbyid_service(int id) {
		return d.findbyid(id);
	}

	
	
}
