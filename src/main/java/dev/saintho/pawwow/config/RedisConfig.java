package dev.saintho.pawwow.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories(basePackages = {"dev.saintho.pawwow.infrastructure.repository.redis"})
@Configuration
public class RedisConfig {
	private final String host;
	private final int port;

	public RedisConfig(@Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") int port) {
		this.host = host;
		this.port = port;
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
	 	return new LettuceConnectionFactory(host, port);
	}
}
