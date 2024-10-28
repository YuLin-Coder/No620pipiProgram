<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>线路更新</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
</head>

<body class="write_bg">
<form action="${pageContext.request.contextPath}/lineServlet" method="post">
  <table width="100%" border="0" cellspacing="0">
      <tr>
      <td height="30">
      	<input type="hidden" name="method"  value="update">
      	<input type="hidden" name="lineNumber"  value="${line.lineNumber}">
       </td>
    </tr>
  </table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="64" height="30"  ></td>
    <td width="771" height="30" valign="top"  class="text_blod_title">更新线路信息</td>
  </tr>
  <tr>
    <td height="15" colspan="2" ><img src="${pageContext.request.contextPath }/images/line1.jpg" width="835" height="6"></td>
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
            <td height="15" colspan="3" align="left" class="text_title">线路信息</td>
          </tr>
          <tr>
            <td height="10" colspan="3"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">车次：</td>
            <td width="14"></td>
            <td class="text_cray"><input type="text" name="trafficCode" id="textfield2" value="${line.trafficCode}"/></td>
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
            <td width="100" height="40" align="left" class="text_cray1">车站名：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="stationName" type="text" class="text_cray" id="textfield2" value="${line.stationName}"/></td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">发车时间：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="departureTime" id="textfield7" value="${line.departureTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">到站时间：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="arrivalTime" id="textfield7" value="${line.arrivalTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">里程：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="mileage" id="textfield7" value="${line.mileage}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">停留时间：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="residenceTime" id="textfield7" value="${line.residenceTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">历时：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="spendTime" id="textfield7" value="${line.spendTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">车站序号：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="stationCode" id="textfield7" value="${line.stationCode}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          
          <tr>
            <td height="10" colspan="6"></td>
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
    <td width="99" height="30" align="center"><input name="button" type="submit" class="buttj" id="button"value=""></td>
    
    <td width="98" ></td>
    <td width="97" align="center">
    <!--  <input name="button2" type="submit" class="butcz" id="button2"value=""> -->
    </td>
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
    <td height="2" background="${pageContext.request.contextPath }/images/bottom_point.gif"></td>
  </tr>
  <tr>
    <td height="25" align="center" background="${pageContext.request.contextPath }/images/bottom_ny_bg.gif" class="text_cray">copyright@12306 购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="${pageContext.request.contextPath }/js/common.js"></script>
</body>
</html>
   
   
   
   
   
   
   