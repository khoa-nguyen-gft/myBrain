package com.example.demo;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
	SpringApplication app = new SpringApplication(DemoApplication.class);
	app.setDefaultProperties(Collections
		.singletonMap("server.port", "8083"));
	app.run(args);
  }

  @GetMapping("/greet")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }
}