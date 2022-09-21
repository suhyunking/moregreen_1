package site.moregreen.basic.like;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.LikeDto;

@Mapper
public interface LikeMapper {


	public int registFundingLike(LikeDto likeDto); //찜하기
	
	public int deleteFundingLike(int l_num); //찜하기 취소
	
	public int fundingLikeCheck(int f_num); //찜하기 중복검사


}
