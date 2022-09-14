package site.moregreen.basic.member;

import java.util.Map;

import org.springframework.validation.Errors;

import site.moregreen.basic.command.MemberDto;

public interface MemberService {

	public int registerMember(MemberDto memberDto);

	public int overlappedID(MemberDto memberDto)throws Exception;

	public Map<String, String> validateHandling(Errors errors); //회원가입 유효성

	 public MemberDto loginMember(MemberDto memberDto);
}
