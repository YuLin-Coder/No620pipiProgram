<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户密码修改</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>

<body class="write_bg">
<script type="text/javascript">
function al(){
	
	alert("密码修改成功");
	 top.location='Index.jsp';
}
function return1(){
	top.location='Index.jsp'; 
}
</script>
<div class="headers"></div>
 <form name="form1" method="post" action="${pageContext.request.contextPath }/userServlet">
 <input type="hidden" name="method" value="modify">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"></td>
  </tr>
</table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>
    <td height="20" colspan="2"></td>
  </tr>
  <tr>
    <td width="64" height="12" ></td>
    <td width="744" height="30" align="left" class="text_blod_title">密码修改</td>
  </tr>
  <tr>
    <td height="15" colspan="2"><img src="../images/line1.jpg" width="835" height="6"></td>
    </tr>
  <tr>
    <td colspan="2"  ><table width="700" border="0" align="center" cellspacing="0">
      <tr>
        <td width="20"></td>
        <td width="100" height="40" class="text_cray1">登录账户：</td>
        <td align="left" class="text_cray1"><input name="ulname" type="text"  class="text_cray" id="textfield4"  size="30" /></td>
      </tr>
      <tr>
        <td width="20" align="center" class="text_red">*</td>
        <td width="100" height="40" class="text_cray1">原密码：</td>
        <td align="left" class="text_cray1"><input name="ulpass" type="text" class="text_cray" id="textfield5" size="30" /></td>
      </tr>
      <tr>
        <td width="20" align="center"  class="text_red">*</td>
        <td width="100" height="40" class="text_cray1">新密码：</td>
        <td align="left" class="text_cray1"><input name="newpass" type="text" class="text_cray" id="textfield6" size="30" /></td>
      </tr>
      <tr>
        <td width="20" align="center" class="text_red">*</td>
        <td width="100" height="40" class="text_cray1">确认新密码：</td>
        <td align="left" class="text_cray1"><input name="newpass1" type="text" class="text_cray" id="textfield7" size="30" /></td>
      </tr>
    </table>
      <br></td>
  </tr>
</table>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="124" height="30"></td>
    <td width="78" align="left"><input name="button" type="submit" class="buttj" id="button"value="" onclick="al()"></td>
    <td width="39" align="center"></td>
    <td align="left"><input name="button2" type="submit" class="butqx" id="button2"value="" onclick="return1()"></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="275"></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="2" background="../images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="../images/bottom_ny_bg.gif" class="text_cray">皮皮虾购票系统</td>
  </tr>
</table>
</form>
</body>
</html>
