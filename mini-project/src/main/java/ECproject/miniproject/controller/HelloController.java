package ECproject.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody //http body부의 데이터를 직접 넣어준다. view가 없이 문자가 그대로 내려감
  public String helloString(@RequestParam("name") String name) {
    return "hello"+name; 
  }

  @GetMapping("hello-api") 
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name) {
    Hello hello= new Hello();
    hello.setName(name);
    return hello;
  }

  static class Hello{
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name= name;
    }
  }


}