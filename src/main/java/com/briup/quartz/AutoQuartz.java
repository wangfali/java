package com.briup.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
* @ClassName: AutoQuartz
* @Description: 任务类 实现任务调度的接口job
* @author wangfali
* @date 2017年7月16日 上午10:07:37
*
 */
public class AutoQuartz implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//执行响应的任务
		System.out.println("AutoQuartz.execute():执行任务类------------"+new Date());
	}

}
