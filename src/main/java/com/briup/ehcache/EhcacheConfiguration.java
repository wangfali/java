package com.briup.ehcache;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @ClassName: EhcacheConfiguration
 * @Description: ehcache缓存框架的配置
 * @author wangfali
 * @date 2017年7月23日 下午7:46:43
 *
 */
public class EhcacheConfiguration implements CachingConfigurer {
	/**
	 * ehcache 主要的管理器
	 */
	@Bean
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());
	}

	/**
	 * 据shared与否的设置,Spring分别通过CacheManager.create() 或new
	 * CacheManager()方式来创建一个ehcache基地.
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		//设置cache的基地是spring独立用，还是与hibernate的ehcache共享
		ehCacheManagerFactoryBean.setShared(true);
		return ehCacheManagerFactoryBean;
	}
	/**
	 * 制定生成缓存key策略，在默认情况下，将直接使用该策略
	 */
	@Bean
	public KeyGenerator defaultKeyGenerator(){
		return new KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				//生成 类名+方法名+加参数的key
				StringBuilder builder = new StringBuilder();
				builder.append(target.getClass().getName());
				builder.append(method.getName());
				for (Object object : params) {
					builder.append(object.toString());
				}
				return builder;
			}
		};
	}
	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager();
	}

	@Override
	public CacheResolver cacheResolver() {
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	@Override
	public CacheErrorHandler errorHandler() {
		return null;
	}

}
