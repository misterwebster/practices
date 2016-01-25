package de.misterwebster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class ExampleController {
  @Controller
  @EnableAutoConfiguration
  public static class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Test!";
    }

    public static void main(String[] args) throws Exception {
      SpringApplication.run(SampleController.class, args);
    }
  }
}
