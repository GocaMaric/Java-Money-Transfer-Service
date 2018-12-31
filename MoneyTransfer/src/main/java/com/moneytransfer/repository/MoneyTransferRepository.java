package com.moneytransfer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.moneytransfer.model.MoneyTransfer;

@Repository
public interface MoneyTransferRepository extends CrudRepository<MoneyTransfer, Integer> {

}
