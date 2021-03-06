package com.zh.SpringBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zh.SpringBootDemo.exception.MyException;


//@RestController  //返回的是json数据
@Controller  //跳转到对应的页面
@RequestMapping(value="/test") 
public class HelloWorldController {
	
	@RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
	
	@RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "securityIndex";  
    }
	
	@RequestMapping("/login")
    public String login() {
        return "login";
    }
	
}