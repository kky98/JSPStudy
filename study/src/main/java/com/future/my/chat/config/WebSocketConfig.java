package com.future.my.chat.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.messaging.SessionConnectEvent;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 처음 접속시 
		registry.addEndpoint("/endpoint").withSockJS();
	}
	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
	}
	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		return true; //
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// subscribe로 시작하는 메세지를 라우팅
		registry.enableSimpleBroker("/subscribe");
		// /app/hello/ + roomNo 형태로 요청이 오면 -> /hello/{roomNo} 으로 전달
		registry.setApplicationDestinationPrefixes("/app");
	}
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectEvent event) {
		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		String userId = sha.getFirstNativeHeader("userId");
		String roomId = sha.getFirstNativeHeader("roomId");
		System.out.println("in:"+userId + "/" + roomId);
		
		Map<String, Object> messge = new HashMap<>();
		messge.put("type", "notification");
		messge.put("message", userId + "님이 입장하셨습니다.");
		messagingTemplate.convertAndSend("/subscribe/chat/" + roomId, messge);
	}

}
