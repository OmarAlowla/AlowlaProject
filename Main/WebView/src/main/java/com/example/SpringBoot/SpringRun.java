package com.example.SpringBoot;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@SpringBootApplication
@Controller
public class SpringRun {

  @Autowired
  private ResourceLoader resourceLoader;
  private main.Controller ct = new main.Controller();
  private main.CookieUtil cu = new main.CookieUtil();

  public static void main(String[] args) {
    SpringApplication.run(SpringRun.class, args);

  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/show")
  public void show(@RequestParam(value = "search", defaultValue = "null") String search, HttpServletResponse response)
  {
    try {
      Resource resource = resourceLoader.getResource("classpath:show.html");
      cu.newCookie(ct.areaArray, "areas",response,resource);
      cu.newCookie(ct.catArray, "cats",response,resource);
      cu.wirteFile(response,resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GetMapping("/showRandom")
  public void showRandom(HttpServletResponse response) {
    try {

      Resource resource = resourceLoader.getResource("classpath:showRandom.html");
      cu.newCookie(ct.randomArray, "randomArray",response,resource);
      cu.wirteFile(response,resource);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
