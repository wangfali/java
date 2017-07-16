package com.briup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan
public class LoveApplication {
//@ComponentScan 告诉Spring寻找其他组件，配置，以及业务层类,最前面才能加载到所有的类。
	public static void main(String[] args) {
		SpringApplication.run(LoveApplication.class, args);
	}
}
