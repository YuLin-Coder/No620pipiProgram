<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列车查找</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function marshallingInsert(){
		document.location.href="${pageContext.request.contextPath}/Marshalling/MarshallingInsert.jsp";
	}
	function marshallingUpdate(){
		document.location.href="${pageContext.request.contextPath}/Marshalling/MarshallingUpdate.jsp";
	}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var marshallingids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<marshallingids.length;i++){
       if(marshallingids[i].checked == false){
        marshallingids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<marshallingids.length;i++){
       if(marshallingids[i].checked == true){
        marshallingids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<marshallingids.length;i++){
       if(marshallingids[i].checked == true){
        marshallingids[i].checked = false;
       }else{
        marshallingids[i].checked = true;
       }
      }
     }
    }
   }  
}

function deletemarshallings(){

	//获取被选中的checkbox值 
	var param="";
	 var checkboxObj=document.getElementsByName("checkbox");
	for(var  i=0;i<checkboxObj.length;i++){
		if(checkboxObj[i].checked==true){
			param+=checkboxObj[i].value+":";	
		}	
	}
	document.location.href="${pageContext.request.contextPath}/marshallingServlet?method=delete&param="+param;
		
}

</script>
</head>
<body class="write_bg">

<div class="headers"></div>

<table width="1107" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"></td>
  </tr>
</table>
<table width="850" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="13" height="30" align="left" valign="top"  ></td>
    <td width="822" align="left" valign="top"  class="text_blod_title">编组查找</td>
  </tr>
  <tr>
    <td height="15" colspan="2" align="center" ><img src="${pageContext.request.contextPath }/images/line.jpg" width="850" height="6"></td>
  </tr>
  <tr>
    <td height="15" colspan="2"  ></td>
  </tr>
</table>

       
<table width="835" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="835" background="${pageContext.request.contextPath }/images/wb_01 (3).jpg">
    
     <form name="form1" method="post" action="${pageContext.request.contextPath }/marshallingServlet">
         	<input type="hidden"  name="method"  value="findMarshallingsByDynamic"/>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         
        <td width="5"></td>
        <td width="9%" height="25" align="left" class="text_cray1">车次代码</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="trafficCode" type="text" class="text_cray" style="width:80px">
        </label></td>
        <td width="6%" align="center" class="text_cray1">车厢号</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="carriageNumber" type="text" class="text_cray" style="width:100px">
        </label></td>
        <td width="9%" align="center" class="text_cray1">座席类型</td>
        <td width="6%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="carSeatType" id="cardType">
                <option value="">==请选择==</option>
                <option value="硬座">硬座</option>
                <option value="软座">软座</option>
                <option value="硬卧上">硬卧上</option>
                <option value="硬卧中">硬卧中</option>
                <option value="硬卧下">硬卧下</option>
           </select>
        </label></td>
        <td width="9%" align="center" class="text_cray1">座席数量</td>
        <td width="11%" align="left" class="text_blod"><label>
           <input name="carSeatNumber" type="text" class="text_cray" style="width:100px"> 
        </label></td>
        <td width="9%" align="center" class="text_cray1">车厢类型</td>
        <td width="13%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="carType" id="cardType">
                <option value="">==请选择==</option>
                <option value="硬座车">硬座车</option>
                <option value="软座车">软座车</option>
                <option value="硬卧车">硬卧车</option>
                <option value="软卧车">软卧车</option>
            </select>
        </label></td>

             
        <td width="8%" align="center" valign="middle" class="text_craybold"><label>
          <input name="Submit" type="submit"  value="查找"> <!-- class="butcx" -->
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="20" colspan="11" align="center">&nbsp;</td>
      </tr>
    </table>
    
       </form>
       
 <table width="100%" border="1" align="center" cellpadding="0" cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
          <tr align="center">
            <td width="44" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">选择</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车次代码</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车厢号</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">座席类型</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">座席数量</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车厢类型</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>
          </tr>
          <tr align="center">
            <td height="15" colspan="7" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">
            <img src="${pageContext.request.contextPath }/images/line1.jpg" width="100%" height="6"></td>
          </tr>
          
          <c:forEach items="${requestScope.marshallingList}" var="marshalling">
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="${marshalling.trainMarshallingNumber}">            </td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${marshalling.trafficCode}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${marshalling.carriageNumber}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${marshalling.carSeatType}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${marshalling.carSeatNumber}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${marshalling.carType}</td>
            <td width="45" bordercolor="#FFFFFF"  class="text_cray1">
             <a href="/pipiProgram/marshallingServlet?method=findmarshallingsById&trainMarshallingNumber=${marshalling.trainMarshallingNumber}" class="text_red">编辑</a>
            </td>
          
          </tr>
         </c:forEach>   
            
        </table>

      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="102" align="left"  class="text_cray1"><a href="#">
              <label></label>
              <label></label>
              <label>
              <input type="checkbox" name="checkbox2" value="11"  onclick="selectAllNullorReserve('checkbox','反选');" ><span class="text_blue">全选</span></label>
            </a></td>
            <td width="525" align="right"  class="text_cray1"><a href="#">
              <input type="button" name="Submit23" value="增加" onClick="marshallingInsert()">
            </a></td>
            <td width="60" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="Submit"  value="删除" onclick="deletemarshallings()"> <!-- class="butsc" -->
            </a></td>
            <td width="60" align="right"  class="text_cray1"><label>
              <input name="Submit3" type="submit"  value="更新" onclick="marshallingUpdate()"> <!-- class="butdc" -->
            </label></td>
          </tr>
        </table>
      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center" style="width:60%">
            <td width="300" align="center"  class="text_cray">&nbsp;</td>
            <td width="700" align="center"  class="text_cray">>> 1 2 3 4 5 6 7 8 &lt;&lt; </td>
            <td width="300" align="right"  class="text_cray1" style="width:20%"><label class="text_cray"> 每页显示
                <select name="select2">
                    <option>10</option>
                    <option>20</option>
                    <option>30</option>
                  </select>
            条信息</label></td>
          </tr>
        </table>
      <br></td>
  </tr>
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

</body>
</html>
