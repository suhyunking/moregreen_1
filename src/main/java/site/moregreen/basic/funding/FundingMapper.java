package site.moregreen.basic.funding;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.hibernate.Criteria;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.command.ImageDto;
import site.moregreen.basic.command.UploadDto;

@Mapper
public interface FundingMapper {

	public boolean updateFunding(FundingDto dto); //펀딩 수정
	

	public List<FundingDto> selectFundigList(Criteria cri); // 펀딩 목록 조회

	public FundingDto selectFundingDetail(int f_num); // 상세조회

	public void createFunding(FundingDto dto); // 등록
	public int createFundingFile(UploadDto dto);

	public List<ImageDto> getDetailImg(int f_num); // 상세 페이지 이미지 조회

	// public int getTotal(Criteria cri); //전체게시글수

}
