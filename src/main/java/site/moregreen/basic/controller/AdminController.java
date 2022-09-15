package site.moregreen.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.command.MemberDto;
import site.moregreen.basic.funding.FundingService;
import site.moregreen.basic.member.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	@Qualifier("fundingService")
	FundingService fundingService;
	
	@Autowired
	@Qualifier("memberService")
	MemberService memberService;
	
	
	@GetMapping("/adminportal")
	public String adminportal() {
		return "admin/adminportal";
	}
	
	@GetMapping("/login")
	public String signIn() {
		return "admin/adminSignin";
	}
	
	@PostMapping("/loginForm")
	public String loginForm(MemberDto memberDto, HttpServletRequest req, RedirectAttributes rttr ) throws Exception {
		HttpSession session =req.getSession();
		 MemberDto member=  memberService.loginMember(memberDto);
		
		 
		 if(member.getM_id().equals("admin")) {
			 session.setAttribute("member", member);
				session.setMaxInactiveInterval(1800);
				//System.out.println("admin 로그인 됨");
				//System.out.println(member);
				return"redirect:/admin/adminportal";
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			//System.out.println("로그인 안됨");
			
		}
		
		return"redirect:/admin/login";
	}
	
	@GetMapping("/fundingList")
	public String fundingList() {
		return "admin/fundingList";
	}
	
	@GetMapping("/fundingConfirm")
	public String fundingConfirm() {
		return "admin/fundingConfirm";
	}
	
	@GetMapping("/fundingApplyList")
	public String fundingApplyList() {
		return "admin/fundingApplyList";
	}

	@GetMapping("/fundingModify")
	public String fundingModify() {
		return "admin/fundingModify";
	}
	
	@PostMapping("/modifyFunding")
	public String modifyFunding(FundingDto dto, RedirectAttributes RA) {
		
		boolean result = fundingService.modifyFunding(dto);
		//메시지처리(리다이렉트 시 1회성 메시지를 보내는 방법)
		if(result) {
			RA.addFlashAttribute("msg", "수정 되었습니다");
		} else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다");
		}
		
		return "redirect:/admin/fundingList";
	}

	@GetMapping("orderList")
	public String orderList() {
		return "admin/orderList";
	}
	
	@GetMapping("userList")
	public String userList() {
		return "admin/userList";
	}
}
