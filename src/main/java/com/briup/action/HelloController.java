package com.briup.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: HelloController
 * @Description: swagger
 * @author wangfali
 * @date 2017年7月29日 下午7:28:02
 *
 */
@Api("HelloController 接口")
@RestController
public class HelloController {
	/**
	 * @Api:用在类上，说明该类的作用
	 * @ApiOperation:用在方法上， 说明方法的作用
	 * @ApiImplicitParams:用在方法上包含一组参数说明
	 * @ApiImplicitParam:用在@ApiImplicitparams注解中，指定一个请求参数的各个方面 paramType:参数放在那个地方
	 *                                                         header---》请求参数的获取：@RequestHeader
	 *                                                         query--->请求参数的获取：@RequestParam
	 *                                                         path（用于restful接口）--》请求参数的获取
	 *                                                         ：pathVariable
	 *                                                         body(不常用) from
	 *                                                         不常用 name:参数名
	 *                                                         datatype 参数类型
	 *                                                         required:参数是否为必须传入
	 *                                                         defaultvalue:参数的默认值
	 * 
	 * @ApiResponse：用在@ApiResponse中，一般用于表达一个错误的响应信息 code数字 如 400
	 * @ApiModel：描述一个model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景 请求参数无法使用@Apiimplicitparam注解进行描述的时候）
	 *                                                            Apimodelproperty
	 *                                                            描述一个model的属性
	 * 
	 */
	// @ApiIgnore
	@ApiOperation(value = "更新用户", notes = "根据url的id来指定更新对象，并根据传来的user信息来更新用户的详细信息")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index() {
		return "Hello World";
	}
}
