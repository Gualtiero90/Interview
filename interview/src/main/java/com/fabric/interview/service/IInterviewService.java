package com.fabric.interview.service;

import com.fabric.interview.dataModel.Balance;
import com.fabric.interview.dataModel.MoneyTransfer;
import com.fabric.interview.dataModel.TransactionList;
import com.fabric.interview.request.MoneyTransferRequestBody;

public interface IInterviewService {

    Balance getAccountBalance(String timeZone, String accountId);

    MoneyTransfer moneyTransfer(String timeZone, String accountId, MoneyTransferRequestBody moneyTransferRequest);

    TransactionList getTransactions(String timeZone, String accountId, String fromAccountingDate, String toAccountingDate);
}
