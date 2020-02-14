package cn.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//    @RestController注解告诉Spring以字符串的形式渲染结果，并直接返回给调用者。
//@RestController 返回的字符串  json等
@RestController
// @EnableAutoConfiguration。 这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
// 由于spring-boot-starter-web添加了Tomcat和Spring MVC，
// 所以auto-configuration将假定你正在开发一个web应用并相应地对Spring进行设置。
//引入第三方组件
//@EnableAutoConfiguration
//@SpringBootApplication工作中用。会扫描App这个类cn.enjoy
//下面所有的包及其子包
@SpringBootApplication
//指定位置的mybatis包扫描
@MapperScan("cn.enjoy.dao")
//允许开启事务管理
@EnableTransactionManagement

public class App {
    //    @RequestMapping注解提供路由信息。
//    它告诉Spring任何来自"/"路径的HTTP请求都应该被映射到home方法。
    @RequestMapping("/")
    String app() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //指定启动类
        SpringApplication.run(App.class, args);
    }

}
/**
 * springboot 打成war包启动类写法
 */

/*@SpringBootApplication
@MapperScan("cn.enjoy.dao")
public class App  extends SpringBootServletInitializer  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

}*/
