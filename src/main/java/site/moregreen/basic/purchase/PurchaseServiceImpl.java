package site.moregreen.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.moregreen.basic.command.DeliveryDto;
import site.moregreen.basic.command.PurchaseDto;
 
@Service("purchaseService") 
@Transactional(readOnly = true)
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PurchaseMapper purchaseMapper;
	
	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public int addPurchase(PurchaseDto purchaseDto, DeliveryDto deliveryDto) {

		purchaseMapper.createDelivery(deliveryDto);
		
		purchaseMapper.createPurchase(purchaseDto);
		
		return 0;
	}
	
}
