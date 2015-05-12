<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
    <c:out value="${requestScope.project.pj_name}"/>
  </div>
  <div class="panel-heading">项目简介:</div>
  <div class="panel-body">
    <c:out value="${requestScope.project.pj_info}"/>
  </div>
  <div class="panel-heading">项目要求:</div>
  <div class="panel-body">
    <c:out value="${requestScope.project.pj_request}"/>
  </div>
</div>
<form class="form-horizontal" role="form" action="JoinProject" method="post">
<button class="btn btn-primary btn-lg btn-block" type="submit" name="">我要参加</button>
<input type="hidden" value=<c:out value="${requestScope.project.pj_id}"/> name="pj_id">
</form>
</body>
</html>