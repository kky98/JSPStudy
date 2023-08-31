<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<body>
		<%@include file="/WEB-INF/inc/top.jsp" %>
		<!-- Contact Section-->
        <section class="page-section" id="contact" style="margin-top: 150px">
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">mypage</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon">
                    	<c:if test="${sessionScope.login.profileImg == null }">
	                    	<img src="${pageContext.request.contextPath}/assets/img/non.png" id="myImage" class="rounded-circle img-thumbnail shadow-sm"
	                    	  width="200" style="cursor:pointer;">
                    	</c:if>
                    	<c:if test="${sessionScope.login.profileImg != null }">
	                    	<img src="${pageContext.request.contextPath}${sessionScope.login.profileImg}" id="myImage" class="rounded-circle img-thumbnail shadow-sm"
	                    	  width="200" style="cursor:pointer;">
                    	</c:if>
                    	
                    	<form id="profileForm" enctype="multipart/form-data">
                    	 	<input type="file" name="uploadImage" id="uploadImage"
                    	 	 accept="image/*" style="display:none;" >
                    	</form>
                    </div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form method="post" action="<c:url value="/registDo" />" >
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="memId" type="text" disabled value="${sessionScope.login.memId }"
                        		   placeholder="아이디를 입력해주세요 ">
                        		<label>아이디</label>
                        	</div>
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="memNm" type="text" value="${sessionScope.login.memNm }"
                        		   placeholder="이름을 입력해주세요 ">
                        		<label>이름</label>
                        	</div>
                        	<div class="form-floating mb-3">
                        		<input class="form-control" name="addr" type="text"  value="${sessionScope.login.addr }"
                        		   placeholder="주소를 입력해주세요">
                        		<label>주소</label>
                        	</div>
                        	<button class="btn btn-primary btn-xl" type="submit">수정하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
		<%@include file="/WEB-INF/inc/footer.jsp" %>
		<script>
			$(document).ready(function(){
				$("#myImage").click(function(){
					$("#uploadImage").click();
				});
				
				$("#uploadImage").on("change", function(){
					let file = $(this)[0].files[0];
					if(file){
						let fileType = file['type'];
						let valTypes = ['image/gif','image/jpeg','image/png','image/jpg'];
						if(!valTypes.includes(fileType)){
							alert("유효한 이미지 타입이 아닙니다.!!");
							$(this).val(''); // 선택파일 초기화 
						}else{
							let formData = new FormData($('#profileForm')[0]);
							console.log(formData);
							$.ajax({
								 url : '<c:url value="/files/upload" /> '
								,type:'POST'
								,data:formData
								,dataType:'json'
								,processData:false
								,contentType:false
								,success:function(res){
									console.log(res);
									$("#myImage").attr("src","${pageContext.request.contextPath}"+ res.imagePath);
								},error: function(e){
									console.log(e);
								}
							});
						}
					}
				});
			});
		</script>
</body>
</html>