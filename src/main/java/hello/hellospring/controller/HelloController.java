package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.RequestContextFilter;

@Controller
public class HelloController {
    private final RequestContextFilter requestContextFilter;


    public HelloController(RequestContextFilter requestContextFilter) {
        this.requestContextFilter = requestContextFilter;
    }

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        // string boot는 hello.html을 resources:templates/에서 찾아 view 함.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //@RequestParam 은 외부에서 parameter를 받겠다는 뜻
        //이름을 웹사이트에서 url 파라미터로 바꾸겠다.
        model.addAttribute("name", name);
        return "hello-template"; //templates로 가서 찾음
    }

    @GetMapping("hello-string")
    @ResponseBody //http 통신 프로토콜의 Body 부분에 직접 이 내용(return)을 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;


        //javaBean 또는 프로퍼티 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
