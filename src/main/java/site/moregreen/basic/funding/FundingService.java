package site.moregreen.basic.funding;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.web.multipart.MultipartFile;

import site.moregreen.basic.command.FundingDto;

public interface FundingService {

	public boolean modifyFunding(FundingDto dto);
	
		// 펀딩 목록 조회
		public List<FundingDto> retriveFundingList(Criteria cri);

		// 펀딩 상세내용 조회
		public FundingDto retriveFundingDetail(int f_num);

		// 등록
		public int addFunding(FundingDto dto, List<MultipartFile> files);
}
