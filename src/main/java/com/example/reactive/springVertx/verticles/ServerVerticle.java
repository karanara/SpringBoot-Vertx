package com.example.reactive.springVertx.verticles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

@Component
public class ServerVerticle extends AbstractVerticle {

	
	@Override
	public void start() throws Exception{
		super.start();
		Router router = Router.router(vertx);
		router.get("/api/getallArticles")
		.handler(this::getAllArticlesRepo);
		
		vertx.createHttpServer()
		.requestHandler(request -> router.handle(request))
		.listen(9090);
		
	}

	private void getAllArticlesRepo(RoutingContext routingContext) {
	    vertx.eventBus().<String>send(ArticleRecipientVerticle.GET_ALL_ARTICLES, "", result -> {
	        if (result.succeeded()) {
	            routingContext.response()
	                    .putHeader("content-type", "application/json")
	                    .setStatusCode(200)
	                    .end(result.result().body());
	        } else {
	            routingContext.response()
	                    .setStatusCode(500)
	                    .end();
	        }
	    });
	}

	
	
}