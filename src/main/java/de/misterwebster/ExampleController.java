package de.misterwebster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@EnableAutoConfiguration
public class ExampleController {
  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Test!";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ExampleController.class, args);
  }

  @RequestMapping({"/home"})
  public String showHomePage(Map<String, Object> model) {
    return "/webapp/WEB-INF/index.html";
  }
}
