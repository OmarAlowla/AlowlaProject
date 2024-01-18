package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class SpringRun {

	@Autowired
	private ResourceLoader resourceLoader;

	public static void main(String[] args) {
		SpringApplication.run(SpringRun.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/show")
	public String show(@RequestParam(value = "search", defaultValue = "null") String search) {
		try {

			Resource resource = resourceLoader.getResource("classpath:show.html");

			return Files.lines(Paths.get(resource.getURI())).collect(Collectors.joining("\n"));
		} catch (IOException e) {

			e.printStackTrace();
			return e+"Error loading show.html";
		}
	}
}