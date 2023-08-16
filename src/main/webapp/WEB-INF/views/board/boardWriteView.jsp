<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>글쓰기</title>
    </head>
    <body id="page-top">
        <!-- 모든 페이지 상단에 들어가는 부분 -->
        <%@include file="/WEB-INF/inc/top.jsp"%>
       
        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container" style="margin-top: 100px;">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">글 작성</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form action="<c:url value="/boardWriteDo" />" method="post">
                            <!-- title input-->
                            <div class="mb-3">
                                <label for="title">제목</label>
                                <input class="form-control" id="title" name="boardTitle" type="text" />
                            </div>
                            <!-- content input-->
                            <div class="mb-3">
                                <textarea class="form-control" name="boardContent" style="height: 20rem"></textarea>
                            </div>
                            <!-- Submit Button-->
                            <button class="btn btn-primary btn-xl" type="submit">등록</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <!-- 모든 페이지 하단에 들어가는 부분 -->
        <!-- Footer-->
        <%@include file="/WEB-INF/inc/footer.jsp"%>
    </body>
</html>