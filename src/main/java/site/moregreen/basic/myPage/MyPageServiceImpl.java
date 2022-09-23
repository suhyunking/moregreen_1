package site.moregreen.basic.myPage;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.java.Log;
import site.moregreen.basic.command.PurchaseDto;
import site.moregreen.basic.util.Criteria;
  
  @Log
  @Service("myPageService")
  @Transactional(readOnly = true) 
  public class MyPageServiceImpl implements MyPageService {
  
  
  @Autowired 
  MyPageMapper myPageMapper;
  
  @Override 
  public List<PurchaseDto> retrieveMyPurchaseList(Criteria cri) {
  
  return null; }
  
  @Override 
  public List<PurchaseDto> retrievePurchaseDetail(int f_num) {
  
  return null; }
  
  
  
  }
 