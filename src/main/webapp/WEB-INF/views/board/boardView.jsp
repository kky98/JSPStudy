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
				<form class="d-flex">
					<select class="form-select me-1" name="searchOption"
						aria-label="Default select example" style="width: 100px">
						<option value="title" selected>제목</option>
						<option value="content">내용</option>
						<option value="name">작성자</option>
					</select> <input class="form-control me-1" type="text" value=""
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
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<!-- 데이터의 수만큼 반복되는 부분 -->
					<c:forEach items="${boardList }" var="board">
						<tr>
							<td>${board.boardNo}</td>
							<td>${board.boardTitle}</td>
							<td>${board.memNm }</td>
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
	<%@include file="/WEB-INF/inc/footer.jsp"%>
</body>
</html>