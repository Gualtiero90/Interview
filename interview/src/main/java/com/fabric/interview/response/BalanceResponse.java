package com.fabric.interview.response;

import com.fabric.interview.dataModel.Balance;

import java.io.Serializable;

public class BalanceResponse implements Serializable {
    private Balance balance;
    private String status;

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
