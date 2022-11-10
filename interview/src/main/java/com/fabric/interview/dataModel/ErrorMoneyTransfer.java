package com.fabric.interview.dataModel;

import java.io.Serializable;
import java.util.List;

public class ErrorMoneyTransfer implements Serializable {

    private String status;
    private List<String> errors;
    private Payload payload;

    public String getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public Payload getPayload() {
        return payload;
    }
}
