<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编组新增</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function setCarSeatType(){
	var carSeatType="${marshalling.carSeatType}";
	var carSeatTypeSelect=document.getElementById('carSeatType');
	var optionsItems=carSeatTypeSelect.options;
	for(var i=0;i<optionsItems.length;i++){
		if(carSeatType==optionsItems[i].value){
			optionsItems[i].selected="selected";
			break;
		}
	}
	
}

function setCarType(){
	var carType="${marshalling.carType}";
	var carTypeSelect=document.getElementById('carType');
	var optionsItems=carTypeSelect.options;
	for(var i=0;i<optionsItems.length;i++){
		if(carType==optionsItems[i].value){
			optionsItems[i].selected="selected";
			break;
		}
	}
	
}
</script>

</head>
<div class="headers"></div>
<body class="write_bg" onload="setCarSeatType();setCarType()">
<form action="${pageContext.request.contextPath}/marshallingServlet" method="post">
  <table width="100%" border="0" cellspacing="0">
      <tr>
      <td height="30">
      	<input type="hidden" name="method"  value="update">
      	<input type="hidden" name="trainMarshallingNumber"  value="${marshalling.trainMarshallingNumber}">
       </td>
    </tr>
  </table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="64" height="30"  ></td>
    <td width="771" height="30" valign="top"  class="text_blod_title">新增编组信息</td>
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
            <td height="15" colspan="3" align="left" class="text_title">列车信息</td>
          </tr>
          <tr>
            <td height="10" colspan="3"></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">车次：</td>
            <td width="14"></td>
            <td class="text_cray"><input type="text" name="trafficCode" id="textfield2" value="${marshalling.trafficCode}"/></td>
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
            <td width="60" height="40" align="left" class="text_cray1">车厢号：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="carriageNumber" type="text" class="text_cray" id="textfield2" value="${marshalling.carriageNumber}"/></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">座席类型：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
            <select class="text_cray" name="carSeatType" id="carSeatType">
                <option value="">==请选择==</option>
                <option value="硬座">硬座</option>
                <option value="软座">软座</option>
                <option value="硬卧上">硬卧上</option>
                <option value="硬卧中">硬卧中</option>
                <option value="硬卧下">硬卧下</option>
            </select></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">座席数量：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="carSeatNumber" type="text" class="text_cray" id="textfield2" value="${marshalling.carSeatNumber}"/></td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">车厢类型：</td>
            <td>&nbsp;</td>
            <td colspan="3" align="left">
            <select class="text_cray" name="carType" id="carType">
                <option value="">==请选择==</option>
                <option value="硬座车">硬座车</option>
                <option value="软座车">软座车</option>
                <option value="硬卧车">硬卧车</option>
                <option value="软卧车">软卧车</option>
                <option value="餐车">餐车</option>
            </select></td>
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
    <!--  <input name="button2" type="submit" class="butcz" id="button2"value="">  -->
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
    <td height="25" align="center" background="${pageContext.request.contextPath }/images/bottom_ny_bg.gif" class="text_cray">皮皮虾购票网</td>
  </tr>
</table>
</form>
<script type="text/JavaScript" src="${pageContext.request.contextPath }/js/common.js"></script>
</body>
</html>
   
   
   
   
   
   
   