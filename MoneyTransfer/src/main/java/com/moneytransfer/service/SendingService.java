package com.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.moneytransfer.model.MoneyTransfer;

@Service
public class SendingService {

  @Autowired
  JmsTemplate jmsTemplate;

  @Value("${spring.activemq.topic}")
  String topic;

  /**
   * Send message.
   */
  public void sendMessage(MoneyTransfer moneyTransfer) {
    try {
      moneyTransfer.setAmount(moneyTransfer.getAmount() * 100);
      jmsTemplate.convertAndSend(topic, moneyTransfer);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
