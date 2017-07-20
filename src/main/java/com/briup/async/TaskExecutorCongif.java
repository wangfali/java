package com.briup.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @ClassName: TaskExecutorCongif
 * @Description: 异步支持
 * @author wangfali
 * @date 2017年7月20日 下午4:48:48
 *
 */
@Configuration
@EnableAsync // 开启异步支持
public class TaskExecutorCongif implements AsyncConfigurer {
	// 核心线程池的大小
	private static final int CORE_POOL_SIZE = 5;
	// 最大线程池的大小
	private static final int MAX_POOL_SIZE = 20;
	// 队列容量
	private static final int QUEUE_CAPCITY = 10;

	/**
	 * 通过重写getAsyncExecutor方法，制定默认的任务执行由该方法产生 这样我们的可以获得一个基于线程池的TaskEexcutor
	 */
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setQueueCapacity(QUEUE_CAPCITY);
		taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
		taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

	/**
	 * 自定义任务执行器：在定义了多个执行器任务的情况下
	 * ，可以使用@Async("getMineAsync")来设定
	 */
	@Bean
	public Executor getMineAsync() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(CORE_POOL_SIZE - 4);
		taskExecutor.setMaxPoolSize(MAX_POOL_SIZE - 10);
		taskExecutor.setQueueCapacity(QUEUE_CAPCITY - 5);
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		taskExecutor.initialize();
		return taskExecutor;
	}
}
