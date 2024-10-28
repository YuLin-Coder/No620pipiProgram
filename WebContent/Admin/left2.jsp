<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/css/left.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.selectbox-0.2.js"></script>
<script type="text/javascript">
$(function () {
	$("[name='country']").selectbox({
		effect:"fade"
		/*以下可无视  注意逗号语法
		onOpen:function(){
			alert("我要打开了！");	
		},
		onChange:function(){
			alert("你选择的值是："+$(this).val());	
		},
		onClose:function(){
			alert("我关闭了！");	
		}*/
	});
	
	$("[name='position']").selectbox({
		effect:"slide"
	});
});
</script>
</head>

<body>
<div class="menu">
            <div class="cont">
                <div class="title">管理员</div>
                <ul class="mList">
                 

	<div class="demo">
		<select name="country" id="country_id">
			<option value="0">系统管理</option>
			
				<option value="1">车站管理</option>
				<option value="2">列车管理</option>
		
			
				<option value="3">线路管理</option>
				<option value="4">编组管理</option>
				
		
			
		</select>
	</div>
	
	<div class="demo">
		<select name="position" id="country_id">
			<option value="0">用户管理</option>
			<option value="1">管理用户</option>
			<option value="2">新增用户</option>
			
		</select>
	</div>

                    
                </ul>
            </div>
        </div>
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
