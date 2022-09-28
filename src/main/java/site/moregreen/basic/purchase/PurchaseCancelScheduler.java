package site.moregreen.basic.purchase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@SpringBootApplication
@EnableScheduling
public class PurchaseCancelScheduler {
	
	@Autowired
	@Qualifier("purchaseService")
	PurchaseService purchaseService;
	
	
	
	@Scheduled(cron = "0 0 0 * * *") //매일 정각에 실행
	public void run() {
		int result = purchaseService.modifyPurchasePayment();
		if(result == 1) {
			LocalDateTime now = LocalDateTime.now();               
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");       
			String formatedNow = now.format(formatter);
			
			log.info("결제 취소 스케줄러" + formatedNow);
			
		}
	}
}
