package com.fabric.interview.response;

import com.fabric.interview.dataModel.ErrorMoneyTransfer;
import com.fabric.interview.dataModel.MoneyTransfer;

import java.io.Serializable;

public class TransferResponse implements Serializable {
    private String status;
    private MoneyTransfer moneyTransferResponse;
    private ErrorMoneyTransfer ErrorMoneyTransfer;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MoneyTransfer getMoneyTransferResponse() {
        return moneyTransferResponse;
    }

    public com.fabric.interview.dataModel.ErrorMoneyTransfer getErrorMoneyTransfer() {
        return ErrorMoneyTransfer;
    }

    public void setErrorMoneyTransfer(com.fabric.interview.dataModel.ErrorMoneyTransfer errorMoneyTransfer) {
        ErrorMoneyTransfer = errorMoneyTransfer;
    }

    public void setMoneyTransferResponse(MoneyTransfer moneyTransferResponse) {
        this.moneyTransferResponse = moneyTransferResponse;


    }
}
