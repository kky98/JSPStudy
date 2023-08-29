<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@include file="/WEB-INF/inc/top.jsp" %>
		<!-- Contact Section-->
        <section class="page-section" id="contact" style="margin-top: 150px">
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">메일전송</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form method="post" action="<c:url value="/sendMailDo" />" >
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="title" type="text" 
                        		   placeholder="제목을 작성해주세요 ">
                        		<label>제목</label>
                        	</div>
                        	<div id="emailArr">
	                        	<div class="form-floating mb-3" id="email0">
	                        		<input class="form-control" name="email[0]" type="email" 
	                        		   placeholder="email주소를 입력해주세요 ">
	                        		<label>이메일 주소</label>
	                        	</div>
                        	</div>
                        	<div class="d-flex justify-content-end">
                        		<button id="addBtn" type="button" class="btn btn-primary">+</button>
                        	</div>
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="content" type="text" 
                        		   placeholder="내용">
                        		<label>내용</label>
                        	</div>
                        	<button class="btn btn-primary btn-xl" type="submit">전송하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
		<%@include file="/WEB-INF/inc/footer.jsp" %>
		<script>
			$(document).ready(function(){
				var cnt =1;
				$("#addBtn").click(function(){
					var clone = $("#email0").clone(true); //1개 있던 input div 복사
					$("#emailArr").append(clone);
				});
			});
		
		</script>
		
		
</body>
</html>