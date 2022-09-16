package site.moregreen.basic.funding;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.util.Criteria;

public interface FundingService {

	public boolean modifyFunding(FundingDto dto);
	
		// 펀딩 목록 조회
		public List<FundingDto> retriveFundingList(Criteria cri);
		
		// 펀딩 이미지 목록 조회
//		public List<UploadDto> retrieveFundingListImg(Criteria cri);

		// 등록
		public int addFunding(FundingDto dto, List<MultipartFile> files, List<MultipartFile> mainFiles, List<MultipartFile> contentFiles);

		// 펀딩 신청 목록 조회
		public List<FundingDto> retrieveFundingApplyList(Criteria cri);
		
		// 총 게시글 수 조회
		public int retrieveTotal(Criteria cri);

		// 펀딩 상세조회
		public List<FundingDto> retrieveFundingDetail(int f_num);

		public int fundingAccept(int f_num);
		public int fundingReject(int f_num);
}
