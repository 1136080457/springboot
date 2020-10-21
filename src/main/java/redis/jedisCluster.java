package redis;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;


@Configuration      //相当于application.xml
public class jedisCluster {
	
	
	@Value("${spring.redis.cluster.nodes}")
	private String nodes;
	
	@Bean          //相当于spring里面的bean
	public JedisCluster jctest(){
		String ss[] = nodes.split(",");    
		Set<HostAndPort> set = new HashSet<HostAndPort>();
		for (String s: ss){
			String sss[] = s.split(":");    //得到主机和端口号
			set.add(new HostAndPort(sss[0] , Integer.parseInt(sss[1])));
		}
		
		JedisCluster  jc = new JedisCluster(set);
	
		return jc;
	}
	
	
}
