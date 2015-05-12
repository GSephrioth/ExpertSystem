<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="MyPro" class="com.hhu.model.ProjectBean" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <script src="js/base.js" type="text/javascript"></script>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">项目名:</div>
  <div class="panel-body">
    <c:out value="${MyPro.pj_name}"/>
  </div>
  <div class="panel-heading">项目简介:</div>
  <div class="panel-body" style="text-align:left">
    <c:out value="${MyPro.pj_info}"/>
  </div>
  <div class="panel-heading">项目要求:</div>
  <div class="panel-body" style="text-align:left">
    <c:out value="${MyPro.pj_request}"/>
  </div>
</div>
<c:if test="${requestScope.StudentList!=null}">
<div class="panel panel-default">
  <div class="panel-heading">学生列表:</div>
  <div class="panel-body">
    <c:forEach var="student" items="${requestScope.StudentList}">

      <a href="http://121.40.75.13:8080/Sc_Corp/ShowJoinStudent?st_id=${student.st_id}&pj_id=${MyPro.pj_id}"><c:out value="${student.st_name}"/></a>
   </c:forEach>
  </div>
</div>
   <form class="form-horizontal" role="form" action="PostMessage.html">
   <button class="btn btn-primary btn-lg btn-block" type="submit" name="">一键群发</button>
   </form>
    <form class="form-horizontal" role="form" action="CloseProject" method="post">
   <button class="btn btn-primary btn-lg btn-block" type="submit" name="">关闭报名</button>
    <input type="hidden" value=<c:out value="${MyPro.pj_id}"/> name="pj_id">
   </form>
   </c:if>
</body>
</html>