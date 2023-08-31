<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<section class="page-section" id="contact">
		<div class="container" style="margin-top: 100px;">
			<div class="d-flex justify-content-end" style="height: 40px">
				<form class="d-flex" action="<c:url value="/searchBoard" />" method="post">
					<select class="form-select me-1" name="searchOption"
						aria-label="Default select example" style="width: 100px">
						<option value="title" selected>제목</option>
						<option value="content">내용</option>
						<option value="name">작성자</option>
					</select> 
					<input class="form-control me-1" type="text" value="" name="keyword"
						style="width: 200px">
					<button class="btn btn-primary" type="submit">
						 <svg xmlns="http://www.w3.org/2000/svg&quot; width=16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						  <path	d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
						</svg>
					</button>
				</form>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>최조작성일</th>
						<th>마지막수정일</th>
					</tr>
				</thead>
				<tbody>
					<!-- 데이터의 수만큼 반복되는 부분 -->
					<c:forEach items="${boardList }" var="board">
						<tr>
							<td>${board.boardNo}</td>
							<td>
							<a href="<c:url value="/boardDetailView?boardNo=${board.boardNo }"/> ">
								      ${board.boardTitle}</a>
						    </td>
							<td>${board.memNm }</td>
							<td>${board.createDate}</td>
							<td>${board.updateDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="<c:url value="boardWriteView" />" >
				<button type="button" class="btn btn-primary">글쓰기</button>
			</a>
		</div>
	</section>
	<table>
		<tr><th>대분류</th>
			<td>
				<select id="mainSelect">
					<option value="" >-- 선택하세요 --</option>
					<c:forEach items="${comList }" var="code">
						<option value="${code.commCd }">${code.commNm }</option>
					</c:forEach>
				</select>
			</td>
			<th>중분류</th>
			<td>
				<select id="subSelect">
					<option value="" >-- 선택하세요 --</option>
				</select>
			</td>
		</tr>
	</table>
	<script>
		$(document).ready(function(){
			$("#mainSelect").on('change', function(){
				let code = $(this).val();
				if(code === ""){
				  $("#subSelect").empty().append("<option value=''>--선택하세요--</option>");
				  return;
				}
				$.ajax({
					 url : '<c:url value="/api/getSubCodes" />'
					,type:'get'
					,data:{commParent : code}
					,dataType:'json'
					,success :function(res){
						$("#subSelect").empty().append("<option value=''>--선택하세요--</option>");
						$.each(res, function(idx, item){
							$("#subSelect").append('<option value="'+item.commCd+'">'
									  +item.commNm + "</option>");
						});
					},error:function(e){
						console.log(e);
					}
				});
			});
		});
	
	
	
	
	
	</script>
	
	<%@include file="/WEB-INF/inc/footer.jsp"%>
</body>
</html>