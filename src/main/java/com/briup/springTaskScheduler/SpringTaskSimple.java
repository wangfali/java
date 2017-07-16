package com.briup.springTaskScheduler;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
* @ClassName: SpringTaskSimple
* @Description: 事务调度的简单使用
* @author wangfali
* @date 2017年7月16日 下午4:16:42
*
 */
//@Configuration
//@EnableScheduling
public class SpringTaskSimple {
// * @Configuration 标记一个类来作为bean定义的应用程序上下文的资源
	@Scheduled(cron="0/10 * * * * *")
	public void task1(){
		System.out.println("SpringTaskSimple.task1()"+new Date());
	}
	@Scheduled(cron="0 0/1 * * * *")
	public void test2(){
		System.out.println("SpringTaskSimple.test2()"+new Date());
	}
}
