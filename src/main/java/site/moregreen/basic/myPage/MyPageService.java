package site.moregreen.basic.myPage;

import java.util.List;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.util.Criteria;

public interface MyPageService {

	//찜목록 리스트 조회
	public List<FundingDto> retrieveFuningLikeList(Criteria cri);
	
	//전체 게시글 수 조회
	public int retrieveTotal(Criteria cri);
}
