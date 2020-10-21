package pojo;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface service {

	public List<people> findall_service();
	public Map<String, Object> findbyid_service(int id);
	
}
