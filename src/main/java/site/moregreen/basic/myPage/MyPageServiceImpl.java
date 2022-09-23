package site.moregreen.basic.myPage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.util.Criteria;

@Service("myPageService")
@Transactional(readOnly = true) //serviceImpl에서 모든 method에 적용됨 (select에서 사용)
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	MyPageMapper myPageMapper;
	
	@Override
	public List<FundingDto> retrieveFuningLikeList(Criteria cri) {
		return myPageMapper.selectFuningLikeList(cri);
	}

	@Override
	public int retrieveTotal(Criteria cri) {
		return myPageMapper.selectTotal(cri);
	}

	
	
}
