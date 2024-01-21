package com.example.SpringBoot;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRun {

  Controller ct = new Controller();

  @Autowired
  private ResourceLoader resourceLoader;

  public static void main(String[] args) {
    SpringApplication.run(SpringRun.class, args);
  }

  @GetMapping("/hello")
  public String hello(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/show")
  public String show(
          @RequestParam(value = "search", defaultValue = "null") String search,
          HttpServletResponse response // Inject HttpServletResponse
  ) {
    try {
      Resource resource = resourceLoader.getResource("classpath:show.html");
      System.out.println(search);

      // Set cookie for randomArray
      CookieUtil.addRandomArrayCookie(response, ct.randomArray);

      return CookieUtil.readFileContent(resource.getURI().getPath());
    } catch (IOException e) {
      e.printStackTrace();
      return e + "Error loading show.html";
    }
  }

  @GetMapping("/showRandom")
  public String showRandom(HttpServletResponse response) {
    try {
      Resource resource = resourceLoader.getResource("classpath:showRandom.html");

      // Set cookie for randomArray
      CookieUtil.addRandomArrayCookie(response, ct.randomArray);

      return CookieUtil.readFileContent(resource.getURI().getPath());
    } catch (IOException e) {
      e.printStackTrace();
      return e + "Error loading showRandom.html";
    }
  }

}
