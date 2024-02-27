package com.example.reactive.springVertx.config;

/*import java.io.IOException;
import java.net.ServerSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PortConfiguration {
	private static final int DEFAULT_PORT = 9090;
	@Profile("default")
	@Bean
	public Integer defaultPort() {
		return DEFAULT_PORT;
	}
	
	@Profile("test")
	@Bean
	public Integer randomPort() {
		try(ServerSocket socket = new ServerSocket(0)){
			return socket.getLocalPort();
		}catch(IOException e) {
			return DEFAULT_PORT;
		}
	}

}*/
