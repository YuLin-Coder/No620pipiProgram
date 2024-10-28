<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增车站信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">


<script language="javascript">
	function station(){
	
		alert('增加成功');
	window.navigate("Station_operation.jsp");
	
	}
</script>


</head>
<body class="write_bg">
<form action="${pageContext.request.contextPath}/stationServlet"  method="post">
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
    <td width="771" height="30" valign="top"  class="text_blod_title">新增车站信息</td>
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
            <td height="10" colspan="3"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="120" height="40" align="left" class="text_cray1">车站代码：</td>
            <td class="text_cray"><input type="text" name="StationCode" id="textfield2" />
            </td>
          </tr>
        </table>
      <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="120" height="40" align="left" class="text_cray1">车站名：</td>
            <td>
              <input type="text" name="StationName" id="textfield2" /></td>
          </tr>
        </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="120" height="40" align="left" class="text_cray1">拼音码：</td>
            <td>
              <input type="text" name="PinyinCode" id="textfield2" /></td>
          </tr>
        </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red"></td>
            <td width="120" height="40" align="left" class="text_cray1">所属铁路局：</td>
            <td>
              <input type="text" name="RailwayBureau" id="textfield2" /></td>
          </tr>
        </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">&nbsp;</td>
            <td width="120" height="40" align="left" class="text_cray1">车站等级：</td>
            <td>
              <input type="text" name="StationgRade" id="textfield2" /></td>
          </tr>
        </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="120" height="40" align="left" class="text_cray1">所属行政区域：</td>
            <td>
              <input type="text" name="AdministrativeRegion" id="textfield2" /></td>
          </tr>
        </table>
        <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="20" colspan="3" ></td>
          </tr>
          
          <tr>
            <td height="10" colspan="3" align="left" class="text_red1"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="120" height="40" align="left" class="text_cray1">联系地址：</td>
            <td>
              <input type="text" name="ContactAddress" id="textfield2" /></td>
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
    <td width="99" height="30" align="center"><input name="button" type="submit" class="buttj" id="button"value=""onClick="station()"></td>
    <td width="98" ></td>
    <td width="97" align="center"><input name="button2" type="submit" class="butcz" id="button2"value=""></td>
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
    <td height="25" align="center" background="../images/bottom_ny_bg.gif" class="text_cray">copyright@皮皮虾购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="../js/common.js"></script>
</body>
</html>