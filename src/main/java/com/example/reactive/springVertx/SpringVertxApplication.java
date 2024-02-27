package com.example.reactive.springVertx;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.reactive.springVertx.bean.Article;
import com.example.reactive.springVertx.repository.ArticleRepository;
import com.example.reactive.springVertx.verticles.ArticleRecipientVerticle;
import com.example.reactive.springVertx.verticles.ServerVerticle;

import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringVertxApplication {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ServerVerticle serverArticle;
	
	@Autowired
	private ArticleRecipientVerticle recipientArticle;

	public static void main(String[] args) {
		SpringApplication.run(SpringVertxApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner->{
			IntStream.range(0, 10)
			.forEach(count->this.articleRepository.save(
					new Article(new Random().nextLong(),
							UUID.randomUUID().toString())));
		};
	}
	
	@PostConstruct
	public void deployVerticle() {
		final Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(serverArticle);
		vertx.deployVerticle(recipientArticle);
	}
	
}
