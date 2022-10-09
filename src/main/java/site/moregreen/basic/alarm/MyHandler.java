package site.moregreen.basic.alarm;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;
import site.moregreen.basic.command.MemberDto;

@Slf4j
@Component
public class MyHandler extends TextWebSocketHandler {

	// 1대1
	Map<String, WebSocketSession> userSessionsMap = new HashMap<String, WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("=================session.toString()============" + session.toString());
		log.debug("세션 연결");
		
		String senderId = getId(session);
		userSessionsMap.put(senderId , session);
		log.debug("senderId = " + senderId);
		log.debug("userSessionsMap = " + userSessionsMap);
		
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		System.out.println("메시지 준비중");
		System.out.println(message.toString());
		
		String msg = message.getPayload();
		
		if(StringUtils.isNotEmpty(msg)) {
			
			String[] strs = msg.split(",");
			
			if(strs != null && strs.length == 4) {
				String cmd = strs[0];
				String caller = strs[1]; 
				String f_num = strs[2];
				String receiver = strs[3];
				//admin이 로그인해서 있다면
				WebSocketSession boardWriterSession = userSessionsMap.get(receiver);
				
				log.debug("==============userSessionsMap==============" + userSessionsMap.get("admin"));
				log.debug("==============cmd==============" + cmd);
				log.debug("==============boardWriterSession==============" + boardWriterSession);
				
				if("fundingRegist".equals(cmd) && boardWriterSession != null) {
					TextMessage tmpMsg = new TextMessage("<a type='external' href='/admin/fundingConfirm?f_num=" + f_num + "'>" + caller + "님이 " + f_num + "번 프로젝트를 개설했습니다.</a>");
					log.debug("연결 성공!");
					log.debug("메시지 = " + tmpMsg.getPayload());
					boardWriterSession.sendMessage(tmpMsg);
					System.out.println("메시지 전송 완료!");
				}
			}
		}
	}
	
	//연결 해제될때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//System.out.println("afterConnectionClosed " + session + ", " + status);
		userSessionsMap.remove(session.getId());
	}
		
	//웹소켓 id 가져오기
	private String getId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		MemberDto loginUser = (MemberDto)httpSession.get("member");
		log.debug("==========session=================" + session);
		log.debug("==========session.getAttributes()=================" + session.getAttributes());
		log.debug("==========httpSession=================" + httpSession);
		log.debug("==========httpSession.get(\"member\")=================" + httpSession.get("member"));
		log.debug("==========loginUser=================" + loginUser);
		if(loginUser == null) {
			log.debug("==========session.getId()=================" + session.getId());
			return session.getId();
		} else {
			log.debug("==========loginUser.getM_id();=================" + loginUser.getM_id());
			return loginUser.getM_id();
		}
	}
	
}