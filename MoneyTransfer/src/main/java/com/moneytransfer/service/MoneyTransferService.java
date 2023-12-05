package com.moneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moneytransfer.model.MoneyTransfer;
import com.moneytransfer.repository.MoneyTransferRepository;
import com.moneytransfer.request.JsonRequest;

import java.util.List;

@Service
public class MoneyTransferService {

    @Autowired
    private SendingService sendingService;

    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    /**
     * Save money transfer details
     *
     * @param jsonRequest
     * @return
     */
    public MoneyTransfer saveMoneyTransfer(JsonRequest jsonRequest) {
        MoneyTransfer moneyTransfer = new MoneyTransfer();
        moneyTransfer.setAmount(jsonRequest.getAmount());
        moneyTransfer.setCurrency(jsonRequest.getCurrency());

        try {
            moneyTransferRepository.save(moneyTransfer);

            // Send Message
            sendingService.sendMessage(moneyTransfer);

            return moneyTransfer;
        } catch (Exception e) {
            // Handle the exception (log, throw, or return an error response)
            e.printStackTrace(); // Consider using a logger instead of printing to the console
            return null;
        }
    }

    /**
     * Get all money transfers
     *
     * @return
     */
    public List<MoneyTransfer> findAll() {
        return moneyTransferRepository.findAll();
    }
}
