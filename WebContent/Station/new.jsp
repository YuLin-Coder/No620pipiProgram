<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>商品的列表页面</h1>
<form id="form1" action="${ pageContext.request.contextPath }/ProductDeleteAllServlet" method="post">
<table border="1" width="800">
	<tr>
		<td colspan="8">
			名称:<input type="text" id="pname" name="pname"><input type="button" value="查询" onclick="search()">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="添加" onclick="addPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="删除" onclick="delAll()"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>	
	</tr>
    <tr align="center">
              <td>请选择</td>
              <td>序号</td>
            <td>车站代码</td>
            <td>车站名</td>
            <td>拼音码</td>
            <td>所属铁路局</td>
            <td>车站等级</td>
            <td>所属行政区域</td>
            <td>联系地址</td>
            <td>操作</td>

          </tr>
	<c:forEach var="s" items="${ pageBean.list }" varStatus="status">
	 <tr align="center" bgcolor="#FFFFFF">
            <td ><input type="checkbox" name="checkbox" value="${s.sId}"> </td>
            <td>${s.sId}</td>
            <td>${s.stationCode}</td>
            <td>${s.stationName}</td>
            <td>${s.pinyinCode}</td>
            <td>${s.railwayBureau}</td>
            <td>${s.stationGrade}</td>
            <td>${s.administrativeRegion}</td>
            <td>${s.contactAddress}</td>
            <td>
            
            <a href="${pageContext.request.contextPath}/stationServlet?method=findStationBytId&sId=${s.sId}" class="text_red">编辑</a></td>
          </tr>
	</c:forEach>
	<tr>
		<%--中间只显示5页  --%>
		<td colspan="8" align="center">
			第${ pageBean.currPage }/${ pageBean.totalPage }页&nbsp;&nbsp;
			总记录数:${ pageBean.totalCount }&nbsp;每页显示的记录数:${ pageBean.pageSize }&nbsp;&nbsp;
			&nbsp;&nbsp;
			<c:if test="${ pageBean.currPage != 1 }">
			<a href="${ pageContext.request.contextPath }/stationServlet?method=fenye&&currPage=1">[首页]</a>
			<a href="${ pageContext.request.contextPath }/stationServlet?method=fenye&&currPage=${ pageBean.currPage - 1 }">[上一页]</a>
			</c:if>
			&nbsp;&nbsp;
			<%-- 如果页数超过了5页 --%>
         
			<c:choose>
				<c:when test="${pageBean.totalPage <=5}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${pageBean.totalPage}"></c:set>
				</c:when>
				
				<c:otherwise>
				<c:set var="begin" value="${pageBean.currPage-2 }"></c:set>
				<c:set var="end" value="${pageBean.currPage+2 }"></c:set>
				<c:if test="${begin-2<=0}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="5"></c:set>
				</c:if>
				<%--如果end超过最大页,设置起始页=最大页-5--%>
				<c:if test="${end>pageBean.totalPage}">
				<c:set var="begin" value="${pageBean.totalPage-5 }"></c:set>
				<c:set var="end" value="${pageBean.totalPage }"></c:set>
				</c:if>
				</c:otherwise>
			
			</c:choose>
			
			<c:forEach var="i" begin="${begin }" end="${end }">
				<c:if test="${ pageBean.currPage != i }">
					<a href="${ pageContext.request.contextPath }/stationServlet?method=fenye&&currPage=${i}">${ i }</a>
				</c:if>
				<c:if test="${ pageBean.currPage == i }">
					${ i }
				</c:if>
			</c:forEach>
			
			&nbsp;&nbsp;
			<c:if test="${ pageBean.currPage != pageBean.totalPage }">
			<a href="${ pageContext.request.contextPath }/stationServlet?method=fenye&&currPage=${ pageBean.currPage + 1}">[下一页]</a>
			<a href="${ pageContext.request.contextPath }/stationServlet?method=fenye&&currPage=${ pageBean.totalPage }">[尾页]</a>
			</c:if>
		</td>	
	</tr>
</table>
</form>
</body>
</html>