package com.briup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan
// * @Configuration tags the class as a source of bean definitions for the application context.
// @Configuration 标记一个类来作为bean定义的应用程序上下文的资源
public class LoveApplication {
//@ComponentScan 告诉Spring寻找其他组件，配置，以及业务层类,最前面才能加载到所有的类。
	public static void main(String[] args) {
		SpringApplication.run(LoveApplication.class, args);
	}
}
