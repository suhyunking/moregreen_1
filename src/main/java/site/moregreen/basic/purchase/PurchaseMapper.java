package site.moregreen.basic.purchase;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.DeliveryDto;
import site.moregreen.basic.command.PurchaseDto;

@Mapper
public interface PurchaseMapper {
	
	public int createPurchase(PurchaseDto purchaseDto);
	public int createDelivery(DeliveryDto deliveryDto);
	
}
