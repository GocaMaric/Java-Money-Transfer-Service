package com.moneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.moneytransfer.model.MoneyTransfer;
import com.moneytransfer.request.JsonRequest;
import com.moneytransfer.service.MoneyTransferService;

@RestController
public class MoneyTransferController {
  
  @Autowired
  private MoneyTransferService moneyTransferService;
  
  /**
   * Send money
   * @param jsonRequest
   * @return
   */
  @PostMapping("/api/send-money")
  public ResponseEntity<Object> createUser(@RequestBody JsonRequest jsonRequest) {
    if(!jsonRequest.getCurrency().equals("EUR")) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You entered wrong currncy, We only accept EUR");
    }
    if(jsonRequest.getAmount() <= -100000000) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount property must not be lower than -100000000 EUR");
    }
    if(jsonRequest.getAmount() >= 100000000) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Amount property must not be larger than +100000000 EUR");
    }
    MoneyTransfer moneyTransfer = moneyTransferService.sendMoney(jsonRequest);
    return ResponseEntity.ok(moneyTransfer);
  }
  
  /**
   * Send money
   * @param jsonRequest
   * @return
   */
  @GetMapping("/api/money-transactions")
  public ResponseEntity<Object> getAllTransactions() {
    return ResponseEntity.ok(moneyTransferService.findAll());
  }
}
