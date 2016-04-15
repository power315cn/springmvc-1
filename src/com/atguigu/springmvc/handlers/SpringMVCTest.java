package com.atguigu.springmvc.handlers;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.entities.User;

@SessionAttributes(value={"user"},types={String.class})
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

	private static final String SUCESS = "sucess";
	
	
	@RequestMapping("/testView")
	public String testView() {
		System.out.println("testView");
		return "helloView";
		
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver() {
		System.out.println("testViewAndViewResolver");
		return SUCESS;
	}
	
	/**
	 * 在方法定义上使用 @ModelAttribute 注解：Spring MVC 
		在调用目标处理方法前，会先逐个调用在方法级上标注了
		@ModelAttribute 的方法。
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required= false) Integer id,
			 Map<String, Object> map) {
		if(id!=null) {
			//模拟从数据库中获取对象
			User user = new User(1, "Tom", "123456", "tom@atguigu.com", 15);
			System.out.println("从数据库中获取对象" + user);
			map.put("abc", user);//键值必须一直
		}
	}
	
	/**
	 * 运行流程：
	 * 1.执行@ModelAttribute 注解修饰的方法：从数据库中获取对象，把
	 * 对象放到map中，键:user
	 * 2.Springmvc 从Map中取出User对象，并把表单的请求参数赋值给User
	 * 对应的对应属性
	 * 3.Springmvc把上述对象传入目标方法的参数
	 */
	@RequestMapping("/testModelAttritute")
	public String testModelAttritute(@ModelAttribute("abc") User user) {
		System.out.println("修改：" + user);
		return SUCESS;
	}
	
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要放到会
		话中的属性外，还可以通过模型属性的对象类型指定哪些
		模型属性需要放到会话中
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User("Tom", "123456", "tom@atguigu.com", 15);
		map.put("user", user);
		map.put("school", "atguigu");
		return SUCESS;
	}
	
	/**
	 * 目标方法可以添加Map 类型的参数
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("Tom","Jerry","Mike"));
		return SUCESS;
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("time",new Date());
		return modelAndView;
	}
	
	@RequestMapping("/testPojo")
	public String testPojo(User user){
		System.out.println("testPojo: " +user);
		return SUCESS;
	}
	
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String al){
		System.out.println("testRequestHeader, Accept-Language: "+al);
		return SUCESS;
	}
	
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String un,
//			@RequestParam(value="age", required=false) Integer a) {
			@RequestParam(value="age", required=false, defaultValue="0") int age) {
		System.out.println("testRequestParam, username: "+un+", age:"+age);
		return SUCESS;
	}
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	public String testRest(@PathVariable Integer id) {
		System.out.println("testRest GET " +id);
		return SUCESS;
	}
	
	@RequestMapping(value="/testRest", method=RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST " );
		return SUCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	public String testRestDetele(@PathVariable Integer id) {
		System.out.println("testRest Detele " +id);
		return SUCESS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest Put " +id);
		return SUCESS;
	}
	
}
