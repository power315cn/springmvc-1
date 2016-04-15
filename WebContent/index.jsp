<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="springmvc/testView">Test View</a>
	<br><br>
	<a href="springmvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
	<br><br>
	<!-- 
		模拟修改操作
		1.原始数据为：1,Tom,123456,tom@atguigu.com,12
		2.密码不能修改
		3.表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	<form action="springmvc/testModelAttritute" method="post">
		<input type="hidden" name="id" value="1"/>
		username:<input type="text" name="username" value="Tom"/>
		<br>
		email:<input type="text" name="email" value="tom@atguigu.com"/>
		<br>
		age:<input type="text" name="age" value="12"/>
		<br>
		<input type="submit"  value="Submit"/>
		<br>
	</form>
	<br><br>
	
	<a href="springmvc/testSessionAttributes">testSessionAttributes</a>
	<br><br>
	<a href="springmvc/testMap">testMap</a>
	<br><br>
	<a href="springmvc/testModelAndView">modelAndView</a>
	<br><br>
	<form action="springmvc/testPojo" method="post">
		username: <input name="username"/><br>
		password: <input type="password" name="password"/><br>
		email: <input name="v"/><br>
		age: <input name="age"/><br>
		province: <input name="address.province"/><br>
		city: <input name="address.city"/><br>
		<input type="submit" value="submit">
	</form>

	<a href="springmvc/testRequestHeader">Test RequestHeader</a>
	<br>
	<br>
	<a href="springmvc/testRequestParam?username=aetguigu&age=12">Test RequestParam</a>
	<br>
	<br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"> 
		<input type="submit" value="TestRest PUT">
	</form>
	<br>
	<br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> 
		<input type="submit" value="TestRest DELETE">
	</form>
	<br>
	<br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST">
	</form>
	<br>
	<br>
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br>
	<br>
	<a href="helloworld">helloworld</a>
	<br>
	<br>
	<a href="springmvc/testRequestMapping">testRequestMapping</a>
	<br>
</body>
</html>