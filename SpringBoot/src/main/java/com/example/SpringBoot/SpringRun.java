package com.example.SpringBoot;

import Logic.Logic; // Import the Logic class
import com.example.Logic.Category.CategoryItem; // Import the CategoryItem class

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringRun {

	public static void main(String[] args) {
		SpringApplication.run(SpringRun.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		// Assuming Logic is a class with a static method getMeals() returning List<Category.CategoryItem>
		List<CategoryItem> meals = Logic.getMeals();

		if (meals != null && !meals.isEmpty()) {
			for (CategoryItem item : meals) {
				System.out.println(item.getName());
			}
		} else {
			System.out.println("No categories found");
		}

		return String.format("Hello %s!", name);
	}
}
