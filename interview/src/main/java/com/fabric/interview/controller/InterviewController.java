package com.fabric.interview.controller;

import com.fabric.interview.dataModel.Balance;
import com.fabric.interview.dataModel.MoneyTransfer;
import com.fabric.interview.dataModel.TransactionList;
import com.fabric.interview.request.MoneyTransferRequestBody;
import com.fabric.interview.response.BalanceResponse;
import com.fabric.interview.response.TransactionResponse;
import com.fabric.interview.response.TransferResponse;
import com.fabric.interview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/interview/banking")
public class InterviewController {

    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @RequestMapping(value = "/{accountId}/getAccountBalance", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public BalanceResponse getAccountBalance(@RequestHeader(value = "X-Time-Zone", required = false) String timeZone,
                                             @PathVariable(value = "accountId") String accountId) {
        BalanceResponse balanceResponse = new BalanceResponse();
        Balance balance = interviewService.getAccountBalance(timeZone,accountId);
        if(balance!=null){
            balanceResponse.setBalance(balance);
            balanceResponse.setStatus("OK");
        }else {
            balanceResponse.setStatus("KO");
        }
        return balanceResponse;
    }

    @RequestMapping(value = "/{accountId}/payments/money-transfers", method = RequestMethod.POST)
    public TransferResponse moneyTransfers(@RequestHeader(value = "X-Time-Zone") String timeZone,
                                      @PathVariable(value = "accountId") String accountId,
                                      @RequestBody MoneyTransferRequestBody transferRequest) {
        TransferResponse transferResponse = new TransferResponse();
        MoneyTransfer restResponse = interviewService.moneyTransfer(timeZone, accountId, transferRequest);
        if (restResponse != null) {
            transferResponse.setMoneyTransferResponse(restResponse);
            transferResponse.setStatus("OK");
        }else{
            transferResponse.setStatus("KO");
        }
        return transferResponse;
    }

    @RequestMapping(value = "/account/{accountId}/getTransactions", method = RequestMethod.GET)
    public TransactionResponse getTransactions(@RequestHeader(value = "X-Time-Zone", required = false)  String timeZone,
                                               @PathVariable(value = "accountId") String accountId,
                                               @RequestParam(value = "fromAccountingDate") String fromAccountingDate ,
                                               @RequestParam(value = "toAccountingDate") String toAccountingDate) {
        TransactionResponse response = new TransactionResponse();
        TransactionList restResponse = interviewService.getTransactions(timeZone, accountId, fromAccountingDate, toAccountingDate);
        if(restResponse.getTransactionList() != null && !restResponse.getTransactionList().isEmpty()){
            response.setList(restResponse.getTransactionList());
            response.setStatus("OK");
        }else{
            response.setStatus("KO");
        }
        return response;
    }
}
