package site.moregreen.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PurchaseCancelScheduler {
	
	@Autowired
	@Qualifier("purchaseService")
	PurchaseService purchaseService;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void run() {
		int result = purchaseService.modifyPurchasePayment();
		log.info("펀딩에 실패하여 결제가 취소되었습니다.");
	}
}
