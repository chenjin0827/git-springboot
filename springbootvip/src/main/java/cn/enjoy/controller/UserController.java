package cn.enjoy.controller;

import cn.enjoy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 在浏览器上输入：localhost:8080/register?username=deer&passwd=123，显示“注册成功”
 * 在浏览器上输入：localhost:8080/login?username=deer&passwd=123，显示“登陆成功”
 * springboot 建议使用logback
 * slf4j(Simple Logging Facade For Java)
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private IUserService iUserService;

    @RequestMapping("/hello")
    String sayHello() {
        logger.info("sayHello日志info记录");
        return "hello";
    }

    @RequestMapping("/login")
    public String login(String username, String passwd) {
        boolean login = iUserService.login(username, passwd);
        if (login) {
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }

    @RequestMapping("/register")
    public String register(String username, String passwd) {
        boolean login = iUserService.register(username, passwd);
        if (login) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/batchAdd")
    public String batchAdd(String username, String passwd) {
        iUserService.batchAdd(username, passwd);
        return "成功";
    }


}
