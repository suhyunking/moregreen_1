package site.moregreen.basic.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/mypage")
public class MypageController {

	@GetMapping("/fundingLikeList")
	public String fundingLikeList() {	
		return "mypage/fundingLikeList";
	}
	
	@GetMapping("/myProjectList")
	public String myProjectList() {
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
	
///////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/fundingLikeList1")
	public String fundingLikeList1() {	
		return "mypage/fundingLikeList1";
	}
	
	@GetMapping("/myProjectList1")
	public String myProjectList1() {
		return "mypage/myProjectList1";
	}
	
	@GetMapping("/purchaseDetail1")
	public String purchaseDetail1() {
		return "mypage/purchaseDetail1";
	}
	
	@GetMapping("/purchaseList1")
	public String purchaseList1() {
		return "mypage/purchaseList1";
	}

	@GetMapping("/test1")
	public String test1() {
		return "include/test1";
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
