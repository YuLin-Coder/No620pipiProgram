<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>
<head>
	<title>皮皮虾铁路登录系统</title>

<link href="css/demoo.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function UserRegistration(){
	
	
	window.location.href="${pageContext.request.contextPath}/UserRegistration.jsp";
	
	
	}
</script>
	
	<!-- For-Mobile-Apps-and-Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Simple Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //For-Mobile-Apps-and-Meta-Tags -->

</head>

<body>
    <h1>皮皮虾铁路登录系统</h1>
    <div class="container w3">
        <h2>现在登录</h2>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
			
			<div class="username">
				<span class="username" style="height:19px">用户:</span>
				<input type="text" name="loginName" class="name" placeholder="用户名/邮箱/手机" required="">
				<div class="clear"></div>
			</div>
			<div class="password-agileits">
				<span class="username"style="height:19px">密码:</span>
				<input type="password" name="password" class="password" placeholder="密码" required="">
				<div class="clear"></div>
			</div>
			<div class="rem-for-agile">
				<input type="checkbox" name="remember" class="remember">记住密码
　　
<br>
				
			</div>
			
			<div class="selects">
				
				<select name="select" class="sel">
					<option value="1">管理员</option>
					<option value="0">用户</option>
				</select>
				</div>
				<div class="login-w3">
					  <input type="submit" class="register" value="注册" onclick="UserRegistration()" >
					
				</div>
			<div class="login-w3">
				  
					<input type="submit" class="login" value="登录">
			</div>
			<div class="clear"></div>
			
		</form>
	</div>
	<div class="footer-w3l">
		<p> 皮皮虾铁路登录系统</p>
	</div>
</body>
</html>