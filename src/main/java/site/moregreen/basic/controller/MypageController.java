package site.moregreen.basic.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import site.moregreen.basic.command.PurchaseDto;
import site.moregreen.basic.myPage.MyPageService;
import site.moregreen.basic.util.Criteria;



@Controller
@RequestMapping("/mypage")
public class MypageController {

	
	@Autowired
	@Qualifier("myPageService")
	MyPageService myPageService;

	
	@GetMapping("/fundingLikeList")
	public String fundingLikeList(Criteria cri, Error error, Model model) {	
		
		
		
		return "mypage/fundingLikeList";
	}
	
	@GetMapping("/myProjectList")
	public String myProjectList(Criteria cri, Error error, Model model) {
		List<PurchaseDto> list = myPageService.retrieveMyPurchaseList(cri);
		return "mypage/myProjectList";
	}
	
	@GetMapping("/purchaseDetail")
	public String purchaseDetail() {
		return "mypage/purchaseDetail";
	}
	
	@GetMapping("/purchaseList")
	public String purchaseList() {
		return "mypage/purchaseList";
	}
	
	@GetMapping("/test")
	public String test() {
		return "mypage/test";
	}


	
//	@GetMapping(value = "/like/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//	@ResponseBody
//	public ResponseEntity<List<fundingDto>> getLikeListWithUserid(@PathVariable("userid") String userid) {
//		//유저아이디를 받는다.
//		log.info("In Controller Userid : " + userid);
//		
//		return new ResponseEntity<>(likeService.getLikeListByUserid(userid), HttpStatus.OK);
//	}


}
