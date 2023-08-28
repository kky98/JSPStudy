<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>채팅</title>
        
        <style>
			.chat-containerK {
				/* overflow: hidden; */
				width : 100%;
				/* max-width : 200px; */
			}
			.chatcontent {
				height: 700px;
				width : 100%;
				/* width:300px; */
				overflow-y: scroll;
			}
			.chat-fix {
				position: fixed;
				bottom: 0;
				width: 100%;
			}
			#alertK{
				display : none;
			}
			#msgi{	
				resize: none;
			}
			.myChat{
				background-color : #E0B1D0;
			}
			li{
				list-style-type:none;
			}
			.chatBox{
				display : inline-block;
			}
			.chatBox dateK{
				vertical-align: text-bottom;
			} 
			.me{
				text-align : right;
				/* text-align:center; */
			}
			.chat-box{
				max-width : 200px;
				display: inline-block;
				border-radius: 15px;
			}
			.notification{
				text-align : center;
			}
		</style>
    </head>
    <body id="page-top">
        <!-- 모든 페이지 상단에 들어가는 부분 -->
    	<%@include file="/WEB-INF/inc/top.jsp"%>
        
        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container" style="margin-top: 100px;">
                <div id="chat-containerK">
					<div class="chatWrap">
						<div class="main_tit">
							<h1>방 정보: </h1>
						</div>
						<div class="content chatcontent border border-secondary" data-room-no="${room.roomNo}" >
							<div id="list-guestbook" class="">

									<!-- 내 채팅일 경우 -->

										<li data-no="" class="me pr-2">
											<strong class="">내이름 이름</strong>
											<div class="me">
												<p class='myChat chat-box text-left p-3'>메세지</p>
     											<strong style="display : inline;" class="align-self-end">작성시간</strong>
											</div>
										</li>

									<!-- 다른사람의 채팅일 경우 -->

										<li data-no="" class="pl-2">
											<strong>다른사람 이름</strong>
											<div>
												<p class='chat-box bg-light p-3'>메세지2</p>
												<strong style="display : inline;" class="align-self-center">작성시간2</strong>
											</div>
										</li>


							</div>
						</div>
						<div>
							<div class="d-flex justify-content-center" style="height: 60px">
								<input type="text" id="msgi" name="msg" class="form-control" style="width: 75%; height: 100%">
								<button type="button" id="btnSend" class="send btn btn-primary" style="width: 25%; height: 100%">보내기</button>
								<button type="button" id="btnOut" class="btn btn-secondary " style="width: 25%; height: 100%">나가기</button>
							</div>
						</div>
					</div>
				</div>
            </div>
        </section>

        <!-- 모든 페이지 하단에 들어가는 부분 -->
        <!-- Footer-->
		<%@include file="/WEB-INF/inc/footer.jsp"%>
		<script src="${pageContext.request.contextPath }/js/sockjs.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>	
		<script>
		  $(document).ready(function(){
			var client;
			//채팅방 스크롤 내리기
			$('.chatcontent').scrollTop($('.chatcontent')[0].scrollHeight);
			//	socket관련
			var chatBox =$(".box");
			var messageInput =$("#msgi");
// 			var roomNo = "${room.roomNo}";
			var roomNo = 1;
			var member = $(".content").data("member");
// 			소켓통신 객체 생성
		    var sock = new SockJS("${pageContext.request.contextPath}/endpoint");
		    client = Stomp.over(sock);
		    //메세지 전송
		    function sendmsg(){
		    	var message = messageInput.val();
		    	if(message == ""){
		    		return false;
		    	}
// 		    	메세지 전달
				client.send('/app/hello/' + roomNo,{}, 
						JSON.stringify({
							 chatMsg : message
							,memId :"${sessionScope.login.memId}"
							,memNm :"${sessionScope.login.memNm}"
							,roomNo : roomNo
						}));
				messageInput.val('');
		    }
		    //최초 연결이 맺어지면 실행
		    client.connect({}, function(){
		    	//상대방이 보낸 메세지를 전달 받을시 실행
		    	client.subscribe("/subscribe/chat/"+ roomNo, function(chat){
		    		console.log(chat);
		    	});
		    });
		    // 메세지 전송 버튼 클릭시
		    $("#btnSend").click(function(){
		    	sendmsg();
		    });
			  
		  });
			
		
		</script>
		
    </body>
</html>


