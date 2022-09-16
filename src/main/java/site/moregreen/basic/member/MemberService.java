package site.moregreen.basic.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;

import site.moregreen.basic.command.MemberDto;

public interface MemberService {
	// 회원가입
	public int registerMember(MemberDto memberDto);
	// 회원 아이디 중복체크
	public int overlappedID(MemberDto memberDto)throws Exception;
	//회원가입 유효성
	public Map<String, String> validateHandling(Errors errors); 
	//회원 로그인
	public MemberDto loginMember(MemberDto memberDto);
	//회원 로그아웃
	public void logout(HttpSession session);
	public int findIdCheck(String m_email);
}
