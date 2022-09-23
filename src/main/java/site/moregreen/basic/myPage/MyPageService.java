package site.moregreen.basic.myPage;

import java.util.List;
import site.moregreen.basic.command.PurchaseDto;
import site.moregreen.basic.util.Criteria;
  
  public interface MyPageService {
  
  public List<PurchaseDto> retrieveMyPurchaseList(Criteria cri);
  
  
  public List<PurchaseDto> retrievePurchaseDetail(int f_num);
  
  }
 