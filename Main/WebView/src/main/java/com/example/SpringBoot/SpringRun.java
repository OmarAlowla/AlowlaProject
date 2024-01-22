package com.example.SpringBoot;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@SpringBootApplication
@Controller
public class SpringRun {

  @Autowired
  private ResourceLoader resourceLoader;
  private main.Controller ct = new main.Controller();

  public static void main(String[] args) {
    SpringApplication.run(SpringRun.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/show")
  public void show(
          @RequestParam(value = "search", defaultValue = "null") String search,
          HttpServletResponse response
  ) {
    try {
      Cookie cookie;
      Resource resource = resourceLoader.getResource("classpath:show.html");
      System.out.println(search);
      cookie = newCookie(ct.areaArray, "areas");
      response.addCookie(cookie);
      cookie = newCookie(ct.catArray, "cats");
      response.addCookie(cookie);

      response.getWriter().write(
              Files.lines(Paths.get(resource.getURI()))
                      .collect(Collectors.joining("\n"))
      );
    } catch (IOException e) {
      e.printStackTrace();
      // Handle the exception appropriately
    }
  }

  @GetMapping("/showRandom")
  public void showRandom(HttpServletResponse response) {
    try {
      Resource resource = resourceLoader.getResource("classpath:showRandom.html");
      Cookie cookie = newCookie(ct.randomArray, "randomArray0");
      response.addCookie(cookie);

      response.getWriter().write(
              Files.lines(Paths.get(resource.getURI()))
                      .collect(Collectors.joining("\n"))
      );
    } catch (IOException e) {
      e.printStackTrace();
      // Handle the exception appropriately
    }
  }
  private Cookie newCookie(String[] array,String name) throws UnsupportedEncodingException {
      Cookie cookie;
      try {
          String encodedArray = URLEncoder.encode(
                  String.join(",", array),
                  "UTF-8"
          );
          cookie = new Cookie(name, encodedArray);
      } catch (UnsupportedEncodingException e) {
          throw new RuntimeException(e);
      }
      return cookie;
  }

}
