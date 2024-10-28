<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列车更新</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function setTrainType(){
	var trainType="${train.trainType}";
	var trainTypeSelect=document.getElementById('trainType');
	var optionsItems=trainTypeSelect.options;
	for(var i=0;i<optionsItems.length;i++){
		if(trainType==optionsItems[i].value){
			optionsItems[i].selected="selected";
			break;
		}
	}
	
}

function setVehicleType(){
	var vehicleType="${train.vehicleType}";
	var vehicleTypeSelect=document.getElementById('vehicleType');
	var optionsItems=vehicleTypeSelect.options;
	for(var i=0;i<optionsItems.length;i++){
		if(vehicleType==optionsItems[i].value){
			optionsItems[i].selected="selected";
			break;
		}
	}
	
}
</script>

</head>



<body class="write_bg" onload="setTrainType();setVehicleType();">
<div class="headers"></div>
<form action="${pageContext.request.contextPath}/trainServlet" method="post">
  <table width="100%" border="0" cellspacing="0">
      <tr>
      <td height="30">
      	<input type="hidden" name="method"  value="update">
      	<input type="hidden" name="tId"  value="${train.tId}">
       </td>
    </tr>
  </table>
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="64" height="30"  ></td>
    <td width="771" height="30" valign="top"  class="text_blod_title">更新列车信息</td>
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
            <td class="text_cray"><input type="text" name="traffic" id="textfield2" value="${train.traffic}"/></td>
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
            <td width="100" height="40" align="left" class="text_cray1">始发站：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="departureStation" type="text" class="text_cray" id="textfield2" value="${train.departureStation}"/></td>
          </tr>
          <tr>
            <td width="20" align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">终到站：</td>
            <td width="14"></td>
            <td colspan="3" align="left"><input name="terminalStation" type="text" class="text_cray" id="textfield2" value="${train.terminalStation}"/></td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">始发时间：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="startingTime" id="textfield7" value="${train.startingTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">终到时间：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="endTime" id="textfield7" value="${train.endTime}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">历时：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="duration" id="textfield7" value="${train.duration}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">里程：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="mileage" id="textfield7" value="${train.mileage}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">无座票数量：</td>
            <td></td>
            <td width="175" align="left" class="text_cray"><input type="text" name="noSeat" id="textfield7" value="${train.noSeat}"/></td>
            <td colspan="2" align="left"></td>
          </tr>
          
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">列车分类：</td>
            <td>&nbsp;</td>
            <td colspan="2" align="left">
            <select class="text_cray" name="vehicleType" id="vehicleType">
                <option value="">==请选择==</option>
                <option value="新空调">新空调</option>
            </select></td>
          </tr>
          <tr>
            <td align="center" class="text_red">*</td>
            <td width="100" height="40" align="left" class="text_cray1">列车类型：</td>
            <td>&nbsp;</td>
            <td colspan="5" align="left">
            <select class="text_cray" name="trainType" id="trainType">
                <option value="">==请选择==</option>
                <option value="普客">普客</option>
                <option value="普快">普快</option>
                <option value="特快">特快</option>
                <option value="特快">特快</option>
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
</body>
</html>
   
   
   
   
   
   
   