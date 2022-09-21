package site.moregreen.basic.purchase;

import site.moregreen.basic.command.DeliveryDto;
import site.moregreen.basic.command.PurchaseDto;

public interface PurchaseService {
	
	public int addPurchase(PurchaseDto purchaseDto, DeliveryDto deliveryDto);
	
}
