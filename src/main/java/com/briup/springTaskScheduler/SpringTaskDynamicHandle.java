package com.briup.springTaskScheduler;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: SpringTaskDynamicHandle
 * @Description: 动态添加修改删除定时任务
 * @author wangfali
 * @date 2017年7月16日 下午4:28:27
 *
 */
@Controller
public class SpringTaskDynamicHandle {
	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	private ScheduledFuture<?> future;

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		return new ThreadPoolTaskScheduler();
	}
	//将任务计划放入任务调度方法，并书写触发器
	@RequestMapping("/start")
	public String startCron() {
		future = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(), new CronTrigger("0/5 * * * * *"));
		return "0/5 * * * * *";
	}
	@RequestMapping("/stop")
	public String stopCron(){
		//判断是否有业务调度线程
		if(future!=null){
			future.cancel(true);
		}
		return "stop";
	}
	@RequestMapping("/change")
	public String startCron10(){
		//先停止该调度线程
		stopCron();
		//重新开始注册新的任务调度
		future = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(),new CronTrigger("*/1 * * * * *"));
		return "*/1 * * * * *";
	}
	//创建任务计划
	private class SpringTaskRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("SpringTaskDynamicHandle.SpringTaskRunnable.run()具体的业务逻辑代码");
		}
	}
}
