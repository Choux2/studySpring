package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //http Get 같은 의미
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //view 템플릿 조작
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") //데이터를 그대로 내려줌(문자)
    @ResponseBody //http 통신 프로토콜 body부에 데이터 넣기
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }


    @GetMapping("hello-api") //객체- json방식으로 데이터를 만들어서 http 응답에 반환
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    //java bean - 프로퍼티 접근 방식
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
