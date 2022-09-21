package site.moregreen.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Setter;
import site.moregreen.basic.command.DeliveryDto;
import site.moregreen.basic.command.FundingDto;
import site.moregreen.basic.command.MemberDto;
import site.moregreen.basic.command.PurchaseDto;
import site.moregreen.basic.kakaoPay.KakaoPay;

@Controller
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
    
    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        
    }
    
    @PostMapping("/kakaoPay")
    public String kakaoPay(FundingDto fundingDto,
    					   PurchaseDto purchaseDto,
    					   DeliveryDto deliveryDto,
    					   MemberDto memberDto) {
    	
        return "redirect:" + kakaopay.kakaoPayReady(fundingDto, purchaseDto, deliveryDto, memberDto);
 
    }
}
