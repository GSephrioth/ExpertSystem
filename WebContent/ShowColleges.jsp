<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>项目查找</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/base.css" rel="stylesheet">
    <script src="js/base.js" type="text/javascript"></script>
</head>
<body>
<form id="df" action="ShowProList" method="post">
            <div class="form-group">
                <select id="pj_depart" name="pj_depart" data-toggle="select"
                        class="form-control select select-primary select-lg">
                    <option value="0">请选择</option>
                    <option value="计信院">计信院</option>
                    <option value="水文源院">水文院</option>
                    <option value="水电院">水电院</option>
                    <option value="港航院">港航院</option>
                    <option value="土木院">土木院</option>
                    <option value="环境院">环境院</option>
                    <option value="能电院">能电院</option>
                    <option value="力材院">力材院</option>
                    <option value="地球院">地球院</option>
                    <option value="理学院">理学院</option>
                    <option value="商学院">商学院</option>
                    <option value="公管院">公管院</option>
                    <option value="法学院">法学院</option>
                    <option value="马院">马院</option>
                    <option value="外院">外院</option>
                    <option value="体育系">体育系</option>
                    <option value="机电工程院">机电工程院</option>
                    <option value="物联网院">物联网院</option>
                    <option value="企业管理院">企业管理院</option>
                </select>
            </div>
        </form>



<div id="dplist" class="list-group">
<c:if test="${requestScope.TotalPage=='0'}">
	<div class="continer">
		<h6>本学院无项目</h6>
		<h6>请选择其它学院</h6>
	</div>
</c:if>
<c:if test="${requestScope.TotalPage!=null && requestScope.TotalPage!='0'}">
<div class="continer">
	<h5>本学院的项目列表</h5>
</div>

<c:forEach var="project" items="${requestScope.ProList}">

    <a class="list-group-item" href="http://121.40.75.13:8080/Sc_Corp/ShowPro?pj_id=${project.pj_id}">
    	<c:out value="${project.pj_name}"/>
    </a>

   </c:forEach>
   
   </div>
<c:if test="${requestScope.pagenum!=null && requestScope.TotalPage!='0'}">
  第 <c:out value="${requestScope.pagenum}"/>页/共 <c:out value="${requestScope.TotalPage}"/>页
  <form class="form-horizontal" role="form" action="ShowProList" method="post">
<button class="btn btn-primary btn-lg btn-block" type="submit" name="">上一页</button>
<input type="hidden" value=${requestScope.depart} name="pj_depart">
<input type="hidden" value=${requestScope.pagenum-1} name="pagenum">
</form>
<form class="form-horizontal" role="form" action="ShowProList" method="post">
<button class="btn btn-primary btn-lg btn-block" type="submit" name="">下一页</button>
<input type="hidden" value=${requestScope.depart} name="pj_depart">
<input type="hidden" value=${requestScope.pagenum+1} name="pagenum">
</form>
<c:out value="${pageScope.depart}"/>

</c:if>
</c:if>
<script type="text/javascript" charset="utf-8">
    $(document).ready(function(){
		$("a").mouseover(function(){$(this).addClass("active");});
		$("a").mouseout(function(){$(this).removeClass("active");});
    });
</script>
<script type="text/javascript" charset="utf-8">
    $(document).ready(function(){
        $("#pj_depart").select2().on("change", function(e){//e就是select元素,on("change")是change事件的监听器
            $("#pj_depart").val(e.val);
        	$("#df").submit();
        });
    });

</script>
</body>
</html>