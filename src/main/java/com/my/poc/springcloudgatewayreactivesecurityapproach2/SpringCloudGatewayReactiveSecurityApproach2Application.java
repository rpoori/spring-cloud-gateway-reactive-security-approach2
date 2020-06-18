package com.my.poc.springcloudgatewayreactivesecurityapproach2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudGatewayReactiveSecurityApproach2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayReactiveSecurityApproach2Application.class, args);
	}

	@PostMapping(value = "/api/document")
	public ResponseEntity<Resource> getDocument() {
		return ResponseEntity.ok(new ClassPathResource("hello-world.pdf"));
	}
}
