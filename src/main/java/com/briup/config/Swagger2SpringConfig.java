package com.briup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
* @ClassName: Swagger2SpringConfig
* @Description: 通过@configuration注解，让spring来加载该类配置，再通过@enableswagger2
* 注解来启用swagger2。再通过createrestapi函数创建docket的bean之后，
* apiinfo()用来创建该api的基本信息（这些基本信息会展示在文档页面中）
* select()函数返回一个apiSelectBuilder实例用来控制那些接口暴露给Swagger来展现
* 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有controller定义的API
* 并产生文档内容（除了被APIignore指定的请求）
* 
* 添加文档内容
* 	在完成了上述配置后，其实已经可以生产文档内容，但是这样的文档主要针对请求本身
* 而描述主要来源于函数的命名产生，对用户并不友好，我们通常需要自己增加一些说明来丰富文档内容
* 如：我们通过@ApiOperation注解来给API增加说明
* 通过@ApiImplicitparams、@apiimplicitparam注解来给参数增加说明
* 
* @author wangfali
* @date 2017年7月29日 下午4:22:18
*
 */
@Configuration
@EnableSwagger2
public class Swagger2SpringConfig {
	//TODO http://localhost:8080/swagger-ui.html
	/**
	 * Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化RESTFUL风格的web服务
	 * 总体目标是使客户端和文件系统作为服务器以同样的速度来更新。
	 * 文件的方法，参数和模型紧密集成到服务器端的代码，允许Api来始终保持同步
	 * Swagger让部署管理和使用功能强大的api从未如此简单
	 * 前后端分离开发API文档非常明确，测试的时候不需要再使用url输入浏览器的方式来访问Controller
	 * 传统的输入url的测试方式对于post请求的传参比较麻烦（当然，可以使用postman这样的浏览器插件）
	 * spring-boot与swagger的集成非常的简单
	 */
	@Bean
	public Docket createReastApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.briup"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo(){
		Contact contact = new Contact("wangfali", "1320895332@qq.com", "1320895332");
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful apis")
				.description("更多的消息请关注我们的官方微信")
				.termsOfServiceUrl("http://github.com")
				.contact(contact)
				.version("2.0.0")
				.build();
		
	}
	
}
