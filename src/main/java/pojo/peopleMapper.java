package pojo;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface peopleMapper {
	/**
	 * people的mybatis对应的映射类,
	 * 根据映射文件中的id去对应方法名字
	 */
		
	
	
	public List<people> findall();
	public Set<people> findd();
}
