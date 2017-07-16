package com.briup.springTaskScheduler;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * 
* @ClassName: SpringTask
* @Description: spring本身集成的动态任务调度，动态修改定时任务的执行周期
* @author wangfali
* @date 2017年7月16日 上午11:48:48
*
 */
//@Component
//@EnableScheduling
public class SpringTask implements SchedulingConfigurer{
	public  static String cron;
	public SpringTask() {
		cron="0/5 * * * * *";
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(30000);
					cron="0/1 * * * * *";
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
			Runnable take = new Runnable() {
				
				@Override
				public void run() {
					/**
					 * 任务逻辑代码部分
					 */
					System.out.println("SpringTask.configureTasks(...).new Runnable() {...}.run()"+new Date());
				}
			};
			Trigger trigger = new Trigger() {
				@Override
				public Date nextExecutionTime(TriggerContext triggerContext) {
					//任务触发，可以修改任务的执行周期
					CronTrigger cronTrigger = new CronTrigger(cron);
					Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
					return nextExecutionTime;
				}
			};
			taskRegistrar.addTriggerTask(take,trigger);
	}

}
