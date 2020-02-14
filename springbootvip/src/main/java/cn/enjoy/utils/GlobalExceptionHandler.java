package cn.enjoy.utils;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//全局异常捕获类
//@ControllerAdvice会拦截所有的requestmapping
@ControllerAdvice
public class GlobalExceptionHandler {
    //    捕获拦截到的RuntimeException异常
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        return "我是个异常处理类";
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (factory -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.do");
            factory.addErrorPages(error404Page);
        });
// 两种写法是等效的  lamda表达式
        /*return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {

            }
        };*/
    }


}
