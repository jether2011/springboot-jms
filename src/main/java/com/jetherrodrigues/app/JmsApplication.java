package com.jetherrodrigues.app;

import com.mongodb.connection.SslSettings;
import com.mongodb.connection.netty.NettyStreamFactoryFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author Jether Rois
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.jetherrodrigues")
@EntityScan("com.jetherrodrigues.domain")
@EnableMongoAuditing
@EnableReactiveMongoRepositories(basePackages = {
		"com.jetherrodrigues.repository"
})
public class JmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(JmsApplication.class, args);
	}
}

