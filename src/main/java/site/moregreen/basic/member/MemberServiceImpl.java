package site.moregreen.basic.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import site.moregreen.basic.command.MemberDto;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	@Override
	public int registerMember(MemberDto memberDto) {
		return memberMapper.insertMember(memberDto);
	}
	
	@Override
	public int overlappedID(MemberDto memberDto) throws Exception {
		int result= memberMapper.overlappedID(memberDto);
		return result;
	}
	
	//회원가입 시 유효성 체크
		@Override
		public Map<String, String> validateHandling(Errors errors) {
			Map<String, String> validatorResult= new HashMap<>();
			for(FieldError error: errors.getFieldErrors()) {
				String validKeyName= String.format("valid_%s", error.getField());
				validatorResult.put(validKeyName, error.getDefaultMessage());
			}
			return validatorResult;
		}

		@Override
		public MemberDto loginMember(MemberDto memberDto) {

			return memberMapper.login(memberDto);
		}

		@Override
		public void logout(HttpSession session) {
			
		}

}
