<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车站查找</title>
<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function stationAdd(){
	
	
	//window.navigate("${pageContext.request.contextPath}/Station/Station_add.jsp");
		document.location.href="${pageContext.request.contextPath}/Station/Station_add.jsp";
	
	}
	
	function stationUpdate(){
		document.location.href="${pageContext.request.contextPath}/Station/Station_update.jsp";
	}
</script>

<script type="text/javascript">


function deletestation(){

	alert('删除成功');window.location.reload();
	//获取被选中的checkbox值 
	var param="";
	 var checkboxObj=document.getElementsByName("checkbox");
	for(var  i=0;i<checkboxObj.length;i++){
		if(checkboxObj[i].checked==true){
			param+=checkboxObj[i].value+":";
			
		}
	
	}
	document.location.href="${pageContext.request.contextPath}/stationServlet?method=delete&param="+param;
	
	
}
</script>

<script>
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var stationids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<stationids.length;i++){
       if(stationids[i].checked == false){
        stationids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<stationids.length;i++){
       if(stationids[i].checked == true){
        stationids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<stationids.length;i++){
       if(stationids[i].checked == true){
        stationids[i].checked = false;
       }else{
        stationids[i].checked = true;
       }
      }
     }
    }
   }  
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
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" colspan="2" ></td>
  </tr>
  <tr>
    <td width="13" height="30" align="left" valign="top"  ></td>
    <td width="822" align="left" valign="top"  class="text_blod_title">车站</td>
  </tr>
  <tr>
    <td height="15" colspan="2" align="center" ><img src="${pageContext.request.contextPath }/images/line.jpg" width="850" height="6"></td>
  </tr>
  <tr>
    <td height="15" colspan="2"  ></td>
  </tr>
</table>

       
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="835" background="${pageContext.request.contextPath }/images/wb_01 (3).jpg">
    
     <form name="form1" method="post" action="${pageContext.request.contextPath }/stationServlet">
         	<input type="hidden"  name="method"  value="findStationsByDynamic"/>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
         
        <td width="5"></td>
        <td width="8%" height="25" align="left" class="text_cray1">车站代码</td>
        <td width="11%" align="left" class="text_cray1">
          <input name="StationCode" type="text" class="text_cray" style="width:100px">
        </td>
        <td width="6%" align="center" class="text_cray1">车站名</td>
        <td width="11%" align="left" class="text_cray1">
          <input name="StationName" type="text" class="text_cray" style="width:100px">
        <td width="9%" align="center" class="text_cray1">车站等级</td>
        <td width="13%" align="left" class="text_cray1">
          <select class="text_cray" name="StationgRade" id="cardType">
                <option value="">====请选择====</option>
                <option value="一">一</option>
                <option value="二">二</option>
                <option value="三">三</option>
            </select>
        </td>
       <td width="9%" align="center" class="text_cray1">所属铁路局</td>
        <td width="6%" align="left" class="text_cray1">
          <select class="text_cray" name="RailwayBureau" id="cardType">
                <option value="">====请选择====</option>
                <option value="北京铁路局">北京铁路局</option>
                <option value="哈尔滨铁路局">哈尔滨铁路局</option>
                <option value="河北铁路局">河北铁路局</option>
                <option value="太原铁路局">太原铁路局</option>
                <option value="呼和浩特铁路局">呼和浩特铁路局</option>
                <option value="辽宁铁路局">辽宁铁路局</option>
                <option value="武汉铁路局">武汉铁路局</option>
                <option value="上海铁路局">上海铁路局</option>
                <option value="广州铁路公司">广州铁路公司</option>
                <option value="南宁铁路局">南宁铁路局</option>
                
           </select>
        </td>
        <td width="9%" align="center" class="text_cray1">所属行政区域</td>
        <td width="13%" align="left" class="text_cray1">
          <select class="text_cray" name="AdministrativeRegion" id="cardType">
                <option value="">====请选择====</option>
                <option value="北京">北京</option>
                <option value="河北">河北</option>
                <option value="天津">天津</option>
                <option value="山西">山西</option>
                <option value="内蒙古">内蒙古</option>
                <option value="辽宁">辽宁</option>
                <option value="广东">广东</option>
            </select>
       </td>

             
        <td width="5%" align="center" valign="middle" class="text_craybold"><label>
          <input name="Submit" type="submit" class="butcx" value="查询">
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
              <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">请选择</td>
              <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">序号</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车站代码</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车站名</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">拼音码</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">所属铁路局</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">车站等级</td>
            <td width="60" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">所属行政区域</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">联系地址</td>
            <td width="45" height="25" valign="middle" bordercolor="#FFFFFF" bgcolor="#FFFFFF"  class="text_cray1">操作</td>

          </tr>
          <tr align="center">
            <td height="15" colspan="11" bordercolor="#FFFFFF" bgcolor="#FFFFFF"   class="text_cray1">
            <img src="${pageContext.request.contextPath }/images/line1.jpg" width="100%" height="6"></td>
          </tr>
          
             <c:forEach items="${requestScope.stationList}" var="s">
          <tr align="center" bgcolor="#FFFFFF">
            <td bordercolor="#FFFFFF"   class="text_cray1"><input type="checkbox" name="checkbox" value="${s.sId}"> </td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.sId}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.stationCode}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.stationName}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.pinyinCode}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.railwayBureau}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.stationGrade}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.administrativeRegion}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">${s.contactAddress}</td>
            <td width="98" bordercolor="#FFFFFF"  class="text_cray1">
            <a href="/pipiProgram/stationServlet?method=findStationBytId&sId=${s.sId}" class="text_red">编辑</a></td>
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
            <input type="button" name="Submit23" value="新增" onClick="stationAdd()"> 
            </a></td>
            <td width="55" align="right"  class="text_cray1"><a href="#">
              <input name="Submit22" type="button"  value="删除"  onclick="deletestation()">
            </a></td>
            
          </tr>
        </table>

      <br>
        <table width="773" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center" style="width:60%">
            <td width="300" align="center"  class="text_cray">&nbsp;</td>
            <td width="750" align="center"  class="text_cray">>> 1 2 3 4 5 6 7 8 &lt;&lt; </td>
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
