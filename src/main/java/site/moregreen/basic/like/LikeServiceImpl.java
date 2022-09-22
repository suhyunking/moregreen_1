package site.moregreen.basic.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.moregreen.basic.command.LikeDto;



@Service("likeService")
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService{

	@Autowired
	LikeMapper likeMapper;
	
	//찜하기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public LikeDto addFundingLike(LikeDto dto, int f_num, int m_num) {
		
		return likeMapper.registFundingLike(dto);
	}

	//찜하기 취소
	@Override
	public int removeFundingLike(int l_num) {
		
		return likeMapper.deleteFundingLike(l_num);
	}

	//찜하기 중복검사
	@Override
	public int retrieveFundingLike(int f_num) {
		
		return likeMapper.fundingLikeCheck(f_num);
	}



}
