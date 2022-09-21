package site.moregreen.basic.member;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.validation.Errors;

import site.moregreen.basic.command.MemberDto;
import site.moregreen.basic.util.Criteria;

@Mapper
public interface MemberMapper {
	    // 회원가입
		public int insertMember(MemberDto memberDto);
		// 회원 아이디 중복체크
		public int overlappedID(MemberDto memberDto)throws Exception;
		//회원가입 유효성
		public Map<String, String> validateHandling(Errors errors); 
		//회원 로그인
		public MemberDto login(MemberDto memberDto);
		//회원 로그아웃
		public void logout(HttpSession session);
		
		//이메일 확인
		public int checkemail(MemberDto memberDto);
		
		//아이디찾기
		public MemberDto findid(MemberDto memberDto);
		//관리자
		public List<MemberDto> selectMemberList(Criteria cri);
		public int selectTotal(Criteria cri);
		
}
