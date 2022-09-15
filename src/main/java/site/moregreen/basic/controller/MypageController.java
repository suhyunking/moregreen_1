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
	
	@GetMapping("/myProgectList")
	public String myProgectList() {
		return "mypage/myProgectList";
	}
	
	@GetMapping("/purchaseDetail")
	public String purchaseDetail() {
		return "mypage/purchaseDetail";
	}
	
	@GetMapping("/purchaseList")
	public String purchaseList() {
		return "mypage/purchaseList";
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
