package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestApplication {

	@Value("#{environment['message']}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@GetMapping("/hello")
	public ResponseGen get(){
		return new ResponseGen("hello from server "+name);
	}

	class ResponseGen{
		String content;
		public ResponseGen() {}
		public ResponseGen(String content) {this.content = content;}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}
