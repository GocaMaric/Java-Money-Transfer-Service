package com.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moneytransfer.model.MoneyTransfer;
import com.moneytransfer.repository.MoneyTransferRepository;
import com.moneytransfer.request.JsonRequest;

@Service
public class MoneyTransferService {
  
  @Autowired
  private SendingService sendingService;
  
  @Autowired
  private MoneyTransferRepository moneyTransferRepository;
  
  /**
   * Save money
   * @param jsonRequest
   * @return
   */
  public MoneyTransfer sendMoney(JsonRequest jsonRequest) {
    MoneyTransfer moneyTransfer = new MoneyTransfer();
    moneyTransfer.setAmount(jsonRequest.getAmount());
    moneyTransfer.setCurrency(jsonRequest.getCurrency());
    moneyTransferRepository.save(moneyTransfer);
    
    //Send Message 
    sendingService.sendMessage(moneyTransfer);
    
    return moneyTransfer;
  }

  public Object findAll() {
    return moneyTransferRepository.findAll();
  }
  
}
