package site.moregreen.basic.member;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.MemberDto;

@Mapper
public interface MemberMapper {
	public int insertMember(MemberDto memberDto); 

	public int overlappedID(MemberDto memberDto) throws Exception; //아이디 중복확인
	
	//로그인
	public MemberDto login(MemberDto memberDto);
}
