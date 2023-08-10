<%@page import="model.BbsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, inital-scale=1.0">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/list.js/2.3.1/list.min.js"></script>
<meta charset="UTF-8">
<title>bbs</title>
</head>
<%
		UserService service = UserService.getInstance();
		ArrayList<BbsVO> arr = service.bbsList();
		pageContext.setAttribute("arr", arr);
%>
<script>
        $(document).ready(function(){
          
                let options = {
                     valueNames: ['bbsTitle','authorId','updateDt']
                    ,page : 10 // 출력 행수 
                    ,pagination :true
                };
                let userList = new List('bbs', options);
           
        }); 
    </script>
<body>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10" id="bbs">
				<div class="input-group">
					<input type="text" class="search form-control" placeholder="search">
					<button class="sort btn input-group-text" data-sort="bbsTitle">제목</button>
				</div>
				<table class="table table-striped" style="text-align: center">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody class="list">
						<c:forEach var="item" items="${arr}">
							<tr>
								<td class="bbsTitle">${item.bbsTitle}</td>
								<td class="authorId">${item.authorId}</td>
								<td class="updateDt">${item.updateDt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-center">
					<ul class="pagination"></ul>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</body>
</html>