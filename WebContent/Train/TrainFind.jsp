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
	function trainInsert(){
		document.location.href="${pageContext.request.contextPath}/Train/TrainInsert.jsp";
	}
	function trainUpdate(){
		document.location.href="${pageContext.request.contextPath}/Train/TrainUpdate.jsp";
	}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var trainids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<trainids.length;i++){
       if(trainids[i].checked == false){
        trainids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<trainids.length;i++){
       if(trainids[i].checked == true){
        trainids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<trainids.length;i++){
       if(trainids[i].checked == true){
        trainids[i].checked = false;
       }else{
        trainids[i].checked = true;
       }
      }
     }
    }
   }  
}

function deleteUsers(){

	//获取被选中的checkbox值 
	var param="";
	 var checkboxObj=document.getElementsByName("checkbox");
	for(var  i=0;i<checkboxObj.length;i++){
		if(checkboxObj[i].checked==true){
			param+=checkboxObj[i].value+":";	
		}	
	}
	document.location.href="${pageContext.request.contextPath}/trainServlet?method=delete&param="+param;
		
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
    <td width="822" align="left" valign="top"  class="text_blod_title">列车查找</td>
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
    
     <form name="form1" method="post" action="${pageContext.request.contextPath }/trainServlet">
         	<input type="hidden"  name="method"  value="findtrainsByDynamic"/>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         
        <td width="5"></td>
        <td width="9%" height="25" align="left" class="text_cray1">车次代码</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="traffic" type="text" class="text_cray" style="width:80px">
        </label></td>
        <td width="6%" align="center" class="text_cray1">始发站</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="departureStation" type="text" class="text_cray" style="width:100px">
        </label></td>
        <td width="6%" align="center" class="text_cray1">终到站</td>
        <td width="11%" align="left" class="text_blod"><label>
           <input name="terminalStation" type="text" class="text_cray" style="width:100px"> 
        </label></td>
       <td width="9%" align="center" class="text_cray1">列车车体</td>
        <td width="6%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="vehicleType" id="cardType">
                <option value="">==请选择==</option>
                <option value="新空调">新空调</option>

           </select>
        </label></td>
        <td width="9%" align="center" class="text_cray1">列车类型</td>
        <td width="13%" align="left" class="text_cray1"><label>
          <select class="text_cray" name="trainType" id="cardType">
                <option value="">==请选择==</option>
                <option value="普客">普客</option>
                <option value="普快">普快</option>
                <option value="特快">特快</option>
                <option value="特快">特快</option>
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
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">始发站</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">终到站</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">始发时间</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">终到时间</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">历时</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">里程</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">无座票</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">列车车体</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">列车类型</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>
          </tr>
          <tr align="center">
            <td height="15" colspan="12" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">
            <img src="${pageContext.request.contextPath }/images/line1.jpg" width="100%" height="6"></td>
          </tr>
          
          <c:forEach items="${requestScope.trainList}" var="train">
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="${train.tId}">            </td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.traffic}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.departureStation}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.terminalStation}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.startingTime}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.endTime}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.duration}</td>
            <td width="45" bordercolor="#FFFFFF"  class="text_cray1">${train.mileage}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.noSeat}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.vehicleType}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${train.trainType}</td>
             <td width="45" bordercolor="#FFFFFF"  class="text_cray1">
             <a href="/pipiProgram/trainServlet?method=findtrainsById&tId=${train.tId}" class="text_red">编辑</a>
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
              <input type="button" name="Submit23" value="增加" onClick="trainInsert()">
            </a></td>
            <td width="60" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="Submit"  value="删除" onclick="deletetrains()"> <!-- class="butsc" -->
            </a></td>

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
