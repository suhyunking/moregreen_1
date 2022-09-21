package site.moregreen.basic.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;
import lombok.extern.java.Log;
import site.moregreen.basic.command.DeliveryDto;
import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.command.PurchaseDto;
import site.moregreen.basic.command.LikeDto;

import site.moregreen.basic.funding.FundingService;
import site.moregreen.basic.kakaoPay.KakaoPay;
import site.moregreen.basic.util.Criteria;
import site.moregreen.basic.util.PageVo;

@Log
@Controller
@RequestMapping("/funding")
public class FundingController {

	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
	
	@Autowired
	@Qualifier("fundingService")
	FundingService fundingService;

	
	
	@GetMapping("/fundingList")
	public String fundingList(Model model, 
							  Criteria cri, 
							  HttpSession session ){
		
		List<FundingDto> fundingList = fundingService.retriveFundingList(cri);
		
		int total = fundingService.retrieveTotal(cri);
		PageVo pageVo = new PageVo(cri, total);

		model.addAttribute("fundingList", fundingList);
		model.addAttribute("pageVO", pageVo);
		
		return "funding/fundingList";
	}
	
	@GetMapping("/fundingDetail")
	public String fundingDetail(@RequestParam("f_num") int f_num, Model model) {
		List<FundingDto> fundingList = fundingService.retrieveFundingDetail(f_num);
		model.addAttribute("fundingList", fundingList);
		return "funding/fundingDetail"; 
	}
	
	@PostMapping("/purchaseForm")
	public String purchaseForm(@RequestParam("f_num") int f_num,
								@Valid PurchaseDto purchaseDto, 
								Model model, Error error) {
		
		DeliveryDto deliveryDto = fundingService.retrieveDelivery(purchaseDto.getM_num());
		model.addAttribute("deliveryDto", deliveryDto);
		
		List<FundingDto> fundingList = fundingService.retrieveFundingDetail(f_num);
		model.addAttribute("fundingList", fundingList);
		
		return "funding/fundingPurchase";
	}
	
	@GetMapping("fundingReg")
	public String fundingReg() {
		return "funding/fundingReg";
	}

	@PostMapping("/fundingForm")
	public String fundingForm(@Valid FundingDto dto, Errors errors, Model model,
						  	  @RequestParam("file") List<MultipartFile> files,
						  	@RequestParam("mainFile") List<MultipartFile> mainFiles,
						  	@RequestParam("contentFile") List<MultipartFile> contentFiles) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for(FieldError err : list) {
				if(err.isBindingFailure() ) {
					model.addAttribute("valid_" + err.getField(), "형식을 일치 시켜주세요");
				}else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
				}
			}
		model.addAttribute("dto", dto);	
		return "funding/fundingReg";
		}
		
		files = files.stream().filter( (f) -> !f.isEmpty()).collect(Collectors.toList());
		//이미지파일검증
		for(MultipartFile f : files ) {
			if( f.getContentType().contains("image") == false ) { //이미지가 아닌경우 다시 등록화면으로
				model.addAttribute("dto", dto);
				model.addAttribute("valid_files", "이미지 형식만 등록 가능합니다");
				return "funding/fundingReg";
			}
		}
		
		mainFiles = mainFiles.stream().filter( (f) -> !f.isEmpty()).collect(Collectors.toList());
		//이미지파일검증
		for(MultipartFile f : mainFiles ) {
			if( f.getContentType().contains("image") == false ) { //이미지가 아닌경우 다시 등록화면으로
				model.addAttribute("dto", dto);
				model.addAttribute("valid_files", "이미지 형식만 등록 가능합니다");
				return "funding/fundingReg";
			}
		}
		
		contentFiles = contentFiles.stream().filter( (f) -> !f.isEmpty()).collect(Collectors.toList());
		//이미지파일검증
		for(MultipartFile f : contentFiles ) {
			if( f.getContentType().contains("image") == false ) { //이미지가 아닌경우 다시 등록화면으로
				model.addAttribute("dto", dto);
				model.addAttribute("valid_files", "이미지 형식만 등록 가능합니다");
				return "funding/fundingReg";
			}
		}
		
		int result = fundingService.addFunding(dto, files, mainFiles, contentFiles);
		return "redirect:/funding/fundingList";

	}

	@GetMapping("fundingPurchase")
	public String fundingPurchase() {
		return "funding/fundingPurchase";
	}

	@GetMapping("fundingPurchaseResult")
	public String fundingPurchaseResult(@RequestParam("pg_token") String pg_token, Model model) {
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
		return "funding/fundingPurchaseResult";
	}
	
	
	  @ResponseBody
	  
	  @PostMapping("/likeUp") public void likeup(@RequestBody LikeDto dto) {
	  System.out.println("컨트롤러 연결 성공");
	  
	  fundingService.addFundingLike(dto);
	  
	  }
	  
	  @ResponseBody
	  
	  @PostMapping("/likeDown") public void likeDown(@RequestBody LikeDto dto) {
	  System.out.println("좋아요 싫어요!");
	  fundingService.removeFundingLike(dto.getL_num()); }
	 	
	
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/liked/check") public int likedCheck(int idx, String id) { int
	 * check = fundingService.getLikeCheck(idx, id);
	 * 
	 * if(check == 0) { fundingService.addFundingLike(idx, id); }else {
	 * fundingService.removeFundingLike(idx, id); } return check; }
	 */	
}
