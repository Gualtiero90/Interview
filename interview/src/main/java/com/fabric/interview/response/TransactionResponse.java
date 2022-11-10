package com.fabric.interview.response;

import com.fabric.interview.dataModel.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponse implements Serializable {
    private String status;
    private List<Transaction> list = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Transaction> getList() {
        return list;
    }

    public void setList(List<Transaction> list) {
        this.list = list;
    }
}
