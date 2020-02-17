package cn.enjoy.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @RequestMapping("/hi")
    public Object sayHi() {
        System.out.println("我进来了");
        return  "hi enjoy";
    }
}
