package site.moregreen.basic.myPage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.util.Criteria;

@Mapper
public interface MyPageMapper {

	public List<FundingDto> selectFuningLikeList(Criteria cri);
	
	public int selectTotal(Criteria cri);
}
