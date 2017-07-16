package com.briup.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.briup.quartz.AutoQuartz;

/**
 * 
 * @ClassName: ApplicationListener
 * @Description: 应用监听类
 * @author wangfali
 * @date 2017年7月16日 上午10:18:41
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	private Scheduler scheduler = null;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		/**
		 * 在Quartz中，scheduler由sheduler工厂创建：direactSchedulerFactory或者StdSchedulerFactory
		 * 第二种工厂StuSchedulerfactory使用比较多，因为direactSchedulerFactory使用起来不够方便，需要作很多
		 * 详细的手工编码设置
		 */
		try {
			// 获取实例
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 开启任务
			scheduler.start();
			System.out.println("ApplicationListener.contextInitialized()");
			System.out.println(scheduler.getSchedulerName());
			// 注册任务
			JobDetail jobDetail = JobBuilder.newJob(AutoQuartz.class).withIdentity("AutoQuartzJob", "AutoQuartzgroup")
					.build();
			// 设置触发的时间（每5秒钟执行一次）
			SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever();
			// 设置触发器
			SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("triggerName", "triggergourp")
					.startNow().withSchedule(simpleScheduleBuilder).build();
			// 交给scheduler安排触发
			scheduler.scheduleJob(jobDetail, simpleTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// 关闭定时任务调度
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
