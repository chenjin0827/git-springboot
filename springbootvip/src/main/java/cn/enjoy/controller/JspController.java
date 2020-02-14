package cn.enjoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://127.0.0.1:8080/jsp/hi
 * 有个坑  配置正确确提示404
 * 这是因为idea默认路径是工程的路径 而不是模块的路径 所以导致多模块无法定位到/WEB-INF/jsp/index.jsp，而独立的模块工程路径就是模块路径  故可以定位，解决办法如下
 * 在idea的run/debug中配置模块路径  working directory： $MODULE_DIR$
 */
@Controller
@RequestMapping("/jsp")
public class JspController {
    @RequestMapping("/hi")
    public String sayHello() {
        return "index";
    }
}
