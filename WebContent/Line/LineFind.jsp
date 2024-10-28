<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>线路查找</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function lineInsert(){
		document.location.href="${pageContext.request.contextPath}/Line/LineInsert.jsp";
	}
	function lineUpdate(){
		document.location.href="${pageContext.request.contextPath}/Line/LineUpdate.jsp";
	}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var lineids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<lineids.length;i++){
       if(lineids[i].checked == false){
        lineids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<lineids.length;i++){
       if(lineids[i].checked == true){
        lineids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<lineids.length;i++){
       if(lineids[i].checked == true){
        lineids[i].checked = false;
       }else{
        lineids[i].checked = true;
       }
      }
     }
    }
   }  
}

function deletelines(){

	//获取被选中的checkbox值 
	var param="";
	 var checkboxObj=document.getElementsByName("checkbox");
	for(var  i=0;i<checkboxObj.length;i++){
		if(checkboxObj[i].checked==true){
			param+=checkboxObj[i].value+":";	
		}	
	}
	document.location.href="${pageContext.request.contextPath}/lineServlet?method=delete&param="+param;
		
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
    <td width="822" align="left" valign="top"  class="text_blod_title">线路查找</td>
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
    
     <form name="form1" method="post" action="${pageContext.request.contextPath }/lineServlet">
         	<input type="hidden"  name="method"  value="findlinesByDynamic"/>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         
        <td width="5"></td>
        <td width="7%" height="25" align="left" class="text_cray1">车次代码</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="trafficCode" type="text" class="text_cray" style="width:100px">
        </label></td>
        <td width="6%" align="center" class="text_cray1">车站名</td>
        <td width="11%" align="left" class="text_cray1"><label>
          <input name="stationName" type="text" class="text_cray" style="width:100px">
        </label></td>
        <td width="7%" align="center" class="text_cray1">车站序号</td>
        <td width="11%" align="left" class="text_blod"><label>
           <input name="stationCode" type="text" class="text_cray" style="width:100px"> 
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
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车站名</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">发车时间</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">到站时间</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">里程</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">停留时间</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">历时</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车站序号</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>
          </tr>
          <tr align="center">
            <td height="15" colspan="10" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">
            <img src="${pageContext.request.contextPath }/images/line1.jpg" width="100%" height="6"></td>
          </tr>
          
          <c:forEach items="${requestScope.lineList}" var="line">
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="${line.lineNumber}">            </td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.trafficCode}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.stationName}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.departureTime}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.arrivalTime}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.mileage}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.residenceTime}</td>
            <td width="45" bordercolor="#FFFFFF"  class="text_cray1">${line.spendTime}</td>
            <td width="60" bordercolor="#FFFFFF"  class="text_cray1">${line.stationCode}</td>
            <td width="45" bordercolor="#FFFFFF"  class="text_cray1">
             <a href="/pipiProgram/lineServlet?method=findlinesById&lineNumber=${line.lineNumber}" class="text_red">编辑</a>
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
              <input type="button" name="Submit23" value="增加" onClick="lineInsert()">
            </a></td>
            <td width="60" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="Submit"  value="删除" onclick="deletelines()"> <!-- class="butsc" -->
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
