package com.moneytransfer.service;

import javax.jms.JMSException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import com.moneytransfer.model.MoneyTransfer;

@Component
public class ReceivingService {

  @JmsListener(destination = "sendmoney")
  @SendTo("money-transder")
  public MoneyTransfer receiveMessage(final MoneyTransfer moneyTransfer) throws JMSException {
    System.out.println("Received message " + moneyTransfer.toString());
    return moneyTransfer;
  }

}
