<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的项目列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <script src="js/base.js" type="text/javascript"></script>
</head>
<body>
<c:if test="${requestScope.TotalPage=='0'}">
	<div class="continer">
		<h6>您尚未参与任何项目</h6>
		<form class="form-horizontal" role="form">
			<button id="back" class="btn btn-primary btn-lg btn-block" type="button" >请返回上一页</button>
    	</form>
	</div>
</c:if>
<c:if test="${requestScope.TotalPage!='0'}">
<div class="continer">
	<h5>我的项目列表</h5>
</div>

<div id="dplist" class="list-group">
<c:forEach var="project" items="${requestScope.MyProjectList}">

    <a class="list-group-item" href="http://121.40.75.13:8080/Sc_Corp/ShowMyPro?pj_id=${project.pj_id}">
		<c:out value="${project.pj_name}"/>
	</a>
   </c:forEach>
</div> 
 <c:if test="${requestScope.pagenum!=null && requestScope.TotalPage!='0'}">
  第 <c:out value="${requestScope.pagenum}"/>页/共 <c:out value="${requestScope.TotalPage}"/>页
<form class="form-horizontal" role="form" action="ShowMyProList" method="post">
	<button class="btn btn-primary btn-lg btn-block" type="submit" name="">上一页</button>
	<input type="hidden" value=${requestScope.pagenum-1} name="pagenum">
</form>
<form class="form-horizontal" role="form" action="ShowMyProList" method="post">
	<button class="btn btn-primary btn-lg btn-block" type="submit" name="">下一页</button>
	<input type="hidden" value=${requestScope.pagenum+1} name="pagenum">
</form>
</c:if>


<c:if test="${requestScope.job=='老师'}">
	<form class="form-horizontal" role="form" action="ReadTeInfo" method="post">
		<button class="btn btn-primary btn-lg btn-block" type="submit" name="">修改个人信息</button>
    </form>
</c:if>
<c:if test="${requestScope.job!='老师'}">
 <form class="form-horizontal" role="form" action="ReadStInfo" method="post">
		<button class="btn btn-primary btn-lg btn-block" type="submit" name="">修改个人信息</button>
    </form>
    
    
</c:if>
</c:if>
<script type="text/javascript" charset="utf-8">

    $(document).ready(function(){
    	$("#back").click(
    			function(){
    				window.history.go(-1);
    				});
		$("a").mouseover(function(){$(this).addClass("active");});
		$("a").mouseout(function(){$(this).removeClass("active");});
    });
</script>
</body>
</html>