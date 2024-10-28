<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="../css/left.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="menu">
            <div class="cont">
                <div class="title">管理员</div>
                <center>
                <ul class="mList">
                    <li>
                        <h3><span onclick="show('menu1','change1')" id="change1">+</span>系统管理</h3>
                        <dl id="menu1" style="display:none;">
<%--                         	<dd id="1"><a href="${pageContext.request.contextPath}/stationServlet?method=findAll" target="mainFrame">车站管理</a></dd>
 --%>                        	<dd id="1"><a href="${pageContext.request.contextPath}/stationServlet?method=fenye&&currPage=1" target="mainFrame">车站管理</a></dd>
                            <dd id="2"><a href="${pageContext.request.contextPath}/trainServlet?method=findAll" target="mainFrame">列车管理</a></dd>
                            <dd id="3"><a href="${pageContext.request.contextPath}/lineServlet?method=findAll" target="mainFrame">线路管理</a></dd>
                            <dd id="4"><a href="${pageContext.request.contextPath}/marshallingServlet?method=findAll" target="mainFrame">编组管理</a></dd>
                        </dl>
                    </li>
                     <li>
                        <h3><span onclick="show('menu2','change2')" id="change2">+</span>用户管理</h3>
                        <dl id="menu2" style="display:none;">
                        	<dd><a href="${pageContext.request.contextPath }/userServlet?method=findAll"" target="mainFrame">管理用户</a></dd>
                            <dd><a href="${pageContext.request.contextPath }/Admin/UserInfo_Add.jsp" "listCate.php" target="mainFrame">新增用户</a></dd>
                        </dl>
                    </li>
              
                    
                </ul>
            </div>
        </div>
        </center>
  <script type="text/javascript">
    	function show(num,change){
	    		var menu=document.getElementById(num);
	    		var change=document.getElementById(change);
	    		if(change.innerHTML=="+"){
	    				change.innerHTML="-";
	        	}else{
						change.innerHTML="+";
	            }
    		   if(menu.style.display=='none'){
    	             menu.style.display='';
    		    }else{
    		         menu.style.display='none';
    		    }
        }
    </script>
</body>
</html>
