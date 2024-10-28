<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增用户信息</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
function run(){
	var pass=document.getElementById('ulpass').value;
	
	var pass1=document.getElementById('ulpass1').value;
if(pass==pass1)
	{
	document.location.href="${pageContext.request.contextPath}/userServlet?method=insert";
	alert("插入成功");
	}
else{
	alert("插入失败");
}	
		
		

	
	//window.navigate("${pageContext.request.contextPath}/Station/Station_add.jsp");
	
		
	}
function return1()
{
	document.location.href="${pageContext.request.contextPath}/userServlet?method=findAll";
	}



</script>
</head>
<div class="headers"></div>
<body class="write_bg">
<form action="${pageContext.request.contextPath }/userServlet"  method="post">
  <table width="100%" border="0" cellspacing="0">
    <tr>
      <td height="30">
      	<input type="hidden" name="method"  value="insert">
       </td>
    </tr>
  </table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="64" height="30"  ></td>
    <td width="771" height="30" valign="top"  class="text_blod_title">新增用户信息</td>
  </tr>
  <tr>
    <td height="15" colspan="2" ><img src="../images/line1.jpg" width="835" height="6"></td>
    </tr>
  <tr>
    <td colspan="2" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="64"></td>
        <td width="771" height="25" align="left" class="text_cray">注：标有<span class="text_red"> *</span> 处，均为必填项</td>
      </tr>
      <tr>
        <td></td>
        <td height="15"></td>
      </tr>
    </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="15" colspan="3" align="left" class="text_title">登录信息</td>
          </tr>
          <tr>
            <td height="10" colspan="3"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">登录名：</td>
            <td class="text_cray"><input type="text" name="ulname" id="textfield2" />
            由字母、数字或“_”组成，长度不少于6位，不多于30位</td>
          </tr>
             <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">密码：</td>
            <td class="text_cray"><input type="text" name="ulpass" id="ulpass" />
            请输入相同的密码</td>
          </tr>
             <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">密码：</td>
            <td class="text_cray"><input type="text" name="ulpass1" id="ulpass1" />
            请输入相同的密码</td>
          </tr>
        </table>
      <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
        
        </table>
      <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="6" ></td>
          </tr>
          <tr>
            <td height="15" colspan="6" align="left" class="text_title">详细信息</td>
          </tr>
          <tr>
            <td height="10" colspan="6" ></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">真实姓名：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="realName" type="text" class="text_cray" id="textfield2" /></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">性 别：</td>
            <td></td>
            <td colspan="3" align="left" class="text_cray1">
              <input name="sex" type="radio" value="男" checked />
              <span class="text_cray">
              <label>男</label>
              <input type="radio" name="sex" value="女" />
                <label>女</label>
                <label></label>
              </span> </td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">省 份：</td>
            <td>&nbsp;</td>
            <td align="left" class="text_cray"><select name="provice" class="text_cray" id="province">
                <option value="省份" selected="selected">省份</option>
            </select> 
            </td>
            <td width="48" align="left" class="text_cray">城市：</td>
            <td width="343" align="left" class="text_cray"><select name="city" class="text_cray" id="city">
                <option value="城市" selected="selected">市县</option>
            </select>            </td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件类型：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left"><select class="text_cray" name="cardType" id="cardType">
                <option value="二代身份证">二代身份证</option>
                <option value="港澳通行证">港澳通行证</option>
                <option value="台湾通行证">台湾通行证</option>
                <option value="护照">护照</option>
            </select>            </td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">证件号码：</td>
            <td></td>
            <td colspan="3" align="left" class="text_cray"><input type="text" name="cardNumber" id="textfield6" /></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">出生日期：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="birthday" id="textfield7" /></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center"></td>
            <td width="100" height="40" align="left" class="text_cray1">旅客类型：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><select class="text_cray" id="passengerType" name="lvkeType">
              <option value="成人" selected="selected">成人</option>
                <option value="儿童">儿童</option>
                <option value="学生">学生</option>
                <option value="残疾军人、伤残人民警察">残疾军人、伤残人民警察</option>
            </select>            </td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td height="10" colspan="6"></td>
          </tr>
          <tr>
            <td align="center"></td>
            <td height="15" align="left" class="text_cray1">备注：</td>
            <td></td>
            <td height="15" colspan="3" align="left"><textarea name="info" style="width:100%" rows="8"></textarea></td>
          </tr>
        </table>
</table><br>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td></td>
  </tr>
</table>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="164"></td>
    <td width="99" height="30" align="center"><input name="button" type="submit"  id="button" value="提交" onclick="run()"></td>
    <td width="98" ></td>
    <td width="97" align="center"><input name="button2" type="submit"  id="button2"value="返回" onclick="return1()"></td>
    <td width="92" ></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="20"></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0">
<tr>
    <td height="2" background="../images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="../images/bottom_ny_bg.gif" class="text_cray">皮皮虾购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="../js/common.js"></script>
</body>
</html>
