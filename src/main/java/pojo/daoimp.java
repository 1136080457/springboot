package pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

/**
 * @author ws
 *
 */
@Service
public class daoimp implements dao{

	@Autowired
	private JdbcTemplate jdbc;
	
	private List<people> list;;
	private Map<String, Object> map;
	
	public List<people> findall_dao() {
		SqlRowSet set = jdbc.queryForRowSet("select * from people order by id asc");
		list = new ArrayList<people>();
		while(set.next()){
			people p = new people();
			Integer i = new Integer(set.getString("id"));
			p.setId(i);
			p.setIdcard(new BigDecimal(set.getString("idcard")));
			p.setName(set.getString("name"));
			p.setAge(new Integer(set.getString("age")));
			p.setSex(new Integer(set.getString("sex")));
			p.setMoney(new Integer(set.getString("money")));
			list.add(p);
		}
		return list;
	}

	
	public Map<String, Object> findbyid(int id) {
		 map = jdbc.queryForMap("select * from people where id="+id);
		 return map;
	}


}
