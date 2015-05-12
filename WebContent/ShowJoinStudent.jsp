<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="MyStudent" class="com.hhu.model.StudentBean" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <script src="js/base.js" type="text/javascript"></script>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">学生名:</div>
  <div class="panel-body">
    <c:out value="${MyStudent.st_name}"/>
  </div>
  <div class="panel-heading">学号:</div>
  <div class="panel-body">
    <c:out value="${MyStudent.st_id}"/>
  </div>
  <div class="panel-heading">学院:</div>
  <div class="panel-body">
    <c:out value="${MyStudent.st_depart}"/>
  </div>
  <div class="panel-heading">学生简介:</div>
  <div class="panel-body" style="text-align:left">
    <c:out value="${MyStudent.st_info}"/>
  </div>
</div>
<div class="panel panel-default">
  <div class="panel-heading">参加的项目列表:</div>
  <c:forEach var="project" items="${requestScope.JoinPro}">
  <div class="panel-body">
	<c:out value="${project.pj_name}"/> 
  </div>
  </c:forEach>
</div>
<form class="form-horizontal" role="form" action="DeleteJoinStudent" method="post">
 	<button class="btn btn-primary btn-lg btn-block" type="submit" name="">删除</button>
  	<input type="hidden" value="${MyStudent.st_id}"  name="st_id">
	<input type="hidden" value="${requestScope.pj_id}"  name="pj_id">
</form>

</body>
</html>