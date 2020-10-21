package redis;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.JedisCluster;

@RestController
public class contraller {

	@Autowired
	private JedisCluster jdc;
	
	
	/**
	 * 
	 * redis集群
	 */
	
	@RequestMapping("rediss")
	public String jc() {
		jdc.set("one", "我是redis集群一号");   //放入缓存
		jdc.set("two", "我是redis集群二号");
		jdc.set("three", "我是redis集群三号");
			
		
		return "one:" + jdc.get("one")+";"+"two:" + jdc.get("two")+";"+"three:" + jdc.get("three");
	}
}
