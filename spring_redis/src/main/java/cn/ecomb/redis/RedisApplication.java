package cn.ecomb.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
public class RedisApplication {

	private static final Logger logger = LoggerFactory.getLogger(RedisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Bean
	public JedisPoolConfig getRedisConfig() {
		return new JedisPoolConfig();
	}

	@Bean
	public RedisConnectionFactory getConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPoolConfig(getRedisConfig());
		logger.info("JedisConnectionFactory bean init success.");
		return factory;
	}

	@Bean
	public RedisTemplate<?, ?> getRedisTemplate(){
		RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());
		return template;
	}

//	@Bean
//	public KeyGenerator wiselyKeyGenerator(){
//		return new KeyGenerator() {
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(target.getClass().getName());
//				sb.append(method.getName());
//				for (Object obj : params) {
//					sb.append(obj.toString());
//				}
//				return sb.toString();
//			}
//		};
//
//	}
//
//	@Bean
//	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//		RedisTemplate<String, String> template = new RedisTemplate<>();
//		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		jackson2JsonRedisSerializer.setObjectMapper(om);
//		template.setValueSerializer(jackson2JsonRedisSerializer);
//		template.afterPropertiesSet();
//		return template;
//	}
//
//	@Bean
//	public CacheManager cacheManager(RedisTemplate redisTemplate) {
//		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//		rcm.setCacheNames(Arrays.asList("thisredis"));
//		rcm.setDefaultExpiration(600);
//		return rcm;
//	}
}
