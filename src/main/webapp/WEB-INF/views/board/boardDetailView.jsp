<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title></title>
    </head>
    <body id="page-top">
        <!-- 모든 페이지 상단에 들어가는 부분 -->
    	<%@include file="/WEB-INF/inc/top.jsp"%>
        
        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container" style="margin-top: 100px;">
                <!-- Contact Section Form-->
                <div class="row justify-content-center" style="margin-bottom: 50px;">
                    <div class="col-lg-8 col-xl-7">
                        <!-- title input-->
                        <div class="mb-3">
                            <label for="title">제목</label>
                            <h6 id="title">${board.boardTitle }</h6>
                        </div>
                        <div class="mb-3">
                            <label for="name">작성자</label>
                            <h6 id="name">${board.memNm }</h6>
                        </div>
                        <div class="mb-3">
                            <label for="date">작성일</label>
                            <h6 id="date">${board.createDate }</h6>
                            <label for="date2">마지막수정일</label>
                            <h6 id="date2">${board.updateDate }</h6>
                        </div>
                        <!-- content input-->
                        <div class="mb-3">
                        	<textarea class="form-control bg-white" style="height: 20rem" readonly>${board.boardContent }</textarea>
                        </div>
                    </div>
	                <c:if test="${sessionScope.login.memId == board.memId }">
	                	<div class="col-lg-8 col-xl-7 d-flex justify-content-end">
	                		<form action="<c:url value="/boardEditView"/>" method="post">
								<input type="hidden" name="boardNo" value="${board.boardNo}" >
				                <button type="submit" class="btn btn-warning me-2" >수정</button>
							</form>
							<form action="<c:url value="/boardDel"/>" method="post">
								<input type="hidden" name="boardNo" value="${board.boardNo}" >
				                <button type="submit" class="btn btn-danger me-2" >삭제</button>
							</form>
	                	</div>
	                </c:if>
                </div>  
                <form id="replyForm" action="<c:url value="/writeRepleDo" />" method="post">
                	<div class="row justify-content-center">
                		<div class="row col-lg-8 col-xl-7">
                			<div class="col-lg-9">
                				<input class="form-control" type="text" id="replyInput" name="replyContent">
                				<input type="hidden" name="memId" value="${sessionScope.login.memId }">
                			</div>
                			<div class="col-lg-3">
                			    <button type="button" class="btn btn-info me-2"
                			     onclick="fn_reply('${sessionScope.login.memId}')" >등록 </button>
                			</div>
                		</div>
                	</div>
                </form>     
                 <div class="row justify-content-center">
                 	<div class="col-lg-8 col-xl-7">
                 		<table class="table">
							<tbody id="replyBody">
							  <c:forEach items="${replyList }" var="reply">
							  	<tr>
							  		<td>${reply.replyContent }</td>
							  		<td>${reply.memNm }</td>
							  		<td>${reply.replyDate }</td>
							  		<td><a>X</a></td>
							  	</tr>
							  </c:forEach>
							</tbody>
                 		</table>
                 	</div>
                 </div>
            </div>
        </section>

        <!-- 모든 페이지 하단에 들어가는 부분 -->
        <!-- Footer-->
		<%@include file="/WEB-INF/inc/footer.jsp"%>
		<script type="text/javascript">
				function fn_reply(p_id){
					if(p_id == ''){
						alert("댓글은 로그인 이후 !!!");
						location.href= '<c:url value="/loginView" />';
					}
					let msg = $('#replyInput').val();
					if(msg == ''){
						alert("내용을 작성해주세요!!!");
						return;
					}
					let json_data = {
						 	 replyContent : msg
							,memId : '${sessionScope.login.memId}'
							,boardNo: '${board.boardNo}'
					};
					$.ajax({
						 url :'<c:url value="/writeReplyDo" />'
						,type :'POST'
						,contentType : 'application/json'
						,dataType : 'json'
						,data : JSON.stringify(json_data)
						,success:function(res){
							
							let str = "";
							str +="<tr>";
							str +="<td>" +res.replyContent+ "</td>";
							str +="<td>" +res.memNm+ "</td>";
							str +="<td>" +res.replyDate+ "</td>";
							str +="<td><a>X</a></td>";
							str +="</tr>";
							$("#replyBody").prepend(str);
							
							
						},error :function(e){
							console.log(e);
						}
					});
				}
		</script>
    </body>
</html>


