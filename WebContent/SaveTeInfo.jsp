<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>老师个人简介</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <script src="js/base.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form id="stuf" method="post" class="form-horizontal" role="form" action="SaveTeInfo" onsubmit="return checksubmit('stuf','确认提交此信息吗？')">
                <div class="form-group" >
                <div class="panel panel-default">
                	<div class="panel-heading">原个人简介：</div>
                	<div class="panel-body">
                		<c:out value="${requestScope.te_info}"/>
                	</div>
                </div>                                                     
                    <label>个人简介</label>
                    <textarea class="form-control" rows="5" name="info" placeholder="请填写您的个人简介" >
                    
                    </textarea>
                    
                    <label>Email</label>
                    <input type="text" class="form-control" name="email" placeholder="请填写您的Email" >
                    
                </div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">保存</button>
            </form>
        </div><!-- /.col-md-12 -->
    </div><!-- /.row -->
</div>
</body>
</html>
