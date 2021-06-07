package com.orangetalents.vecontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableSpringDataWebSupport
public class VecontrolApplication {

	public static final String URL = "https://parallelum.com.br/fipe/api/v1";

	@Bean
	public WebClient webClientFipe(WebClient.Builder builder) {
		return builder
				.baseUrl(URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(VecontrolApplication.class, args);
	}

}
