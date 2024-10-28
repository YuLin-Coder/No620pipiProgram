<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>

<link href="../css/topp.css" rel="stylesheet" type="text/css">
<script type="text/javascript"> 
function toNewWindow() { 
window.top.location.href="${pageContext.request.contextPath }/Login.jsp"; 
} 
</script>
	</head>
	<body>
		<div class="layui-header header header-demo">
                <div class="layui-main">
                    <a class="logo" href="./index.html">
                   <img class="pipi" src="../images/pip.jpg"></img>
                    </a>
                    <ul class="layui-nav" lay-filter="">
                      <li class="layui-nav-item"><img src="../images/0.jpg" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">admin</a>
                        <dl class="layui-nav-child"> <!-- 二级菜单 -->
                          <dd><a href="#">个人信息</a></dd>
                          <dd><a href="#">切换帐号</a></dd>
                          <dd><a href="./login.html">退出</a></dd>
                        </dl>
                      </li>
                      <!-- <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                        </li> -->
                      <li class="layui-nav-item x-index"><a href="javascript:toNewWindow()">前台首页</a></li>
                    </ul>
                </div>
              <div class="foot"></div>
            </div>
	</body>
</html>
