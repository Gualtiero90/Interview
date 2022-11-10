package com.fabric.interview.dataModel;

import java.time.LocalDate;

public class Amount {
    private long debtorAmount;
    private String debtorCurrency;
    private long creditorAmount;
    private String creditorCurrency;
    private LocalDate creditorCurrencyDate;
    private long exchangeRate;

    public long getDebtorAmount() {
        return debtorAmount;
    }

    public void setDebtorAmount(long debtorAmount) {
        this.debtorAmount = debtorAmount;
    }

    public String getDebtorCurrency() {
        return debtorCurrency;
    }

    public void setDebtorCurrency(String debtorCurrency) {
        this.debtorCurrency = debtorCurrency;
    }

    public long getCreditorAmount() {
        return creditorAmount;
    }

    public void setCreditorAmount(long creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    public String getCreditorCurrency() {
        return creditorCurrency;
    }

    public void setCreditorCurrency(String creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    public LocalDate getCreditorCurrencyDate() {
        return creditorCurrencyDate;
    }

    public void setCreditorCurrencyDate(LocalDate creditorCurrencyDate) {
        this.creditorCurrencyDate = creditorCurrencyDate;
    }

    public long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
