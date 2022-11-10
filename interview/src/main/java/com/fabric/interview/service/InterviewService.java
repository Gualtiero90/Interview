package com.fabric.interview.service;

import com.fabric.interview.dataModel.Balance;
import com.fabric.interview.dataModel.MoneyTransfer;
import com.fabric.interview.dataModel.TransactionList;
import com.fabric.interview.request.MoneyTransferRequestBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class InterviewService implements IInterviewService {

    @Value("${api.domain}")
    private String domain;
    @Value("${api.getBalance}")
    private String getAccountBalance;
    @Value("${api.moneyTransfer}")
    private String moneyTransfer;
    @Value("${api.getTransactions}")
    private String getTransaction;

    private final RestTemplate restTemplate;
    private final Logger logger = LogManager.getLogger(InterviewService.class);


    @Autowired
    public InterviewService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Balance getAccountBalance(String timeZone, String accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        String url = domain + accountId + getAccountBalance;
        Balance balance = new Balance();
        if (timeZone != null && !timeZone.isEmpty()) {
            httpHeaders.set("X-Time-Zone", timeZone);
        }
        logger.info("Start call getBalance");
        try {
            HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<Balance> response = restTemplate.exchange(
                    url, HttpMethod.GET, requestEntity, Balance.class);
            balance = response.getBody();
        } catch (Exception e) {
            logger.info("Errore durante la chiamata getBalance: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return balance;
    }

    @Override
    public MoneyTransfer moneyTransfer(String timeZone, String accountId, MoneyTransferRequestBody moneyTransferRequest) {
        String completeUrl = domain + accountId + moneyTransfer;
        HttpHeaders httpHeaders = new HttpHeaders();
        MoneyTransfer moneyTransfer = new MoneyTransfer();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(completeUrl);
        if (timeZone != null && !timeZone.isEmpty()) {
            httpHeaders.set("X-Time-Zone", timeZone);
        }
        try {
            HttpEntity<MoneyTransferRequestBody> requestEntity = new HttpEntity<>(moneyTransferRequest, httpHeaders);
            ResponseEntity<MoneyTransfer> response = restTemplate.postForEntity(
                    builder.toUriString(), requestEntity.toString(), MoneyTransfer.class);
            moneyTransfer = response.getBody();
        } catch (Exception e) {
            logger.error("Errore durante la chiamata sendMoneyTransfer: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return moneyTransfer;
    }

    @Override
    public TransactionList getTransactions(String timeZone, String accountId, String fromAccountingDate, String toAccountingDate) {
        TransactionList transactionList = new TransactionList();
        String completeUrl = domain + accountId + getTransaction;
        HttpHeaders httpHeaders = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(completeUrl);
        builder.queryParam("fromAccountingDate", fromAccountingDate);
        builder.queryParam("toAccountingDate", toAccountingDate);
        if (timeZone != null && timeZone.isEmpty()) {
            httpHeaders.set("X-Time-Zone", timeZone);
        }
        try {
            HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<TransactionList> response = restTemplate.exchange(
                    builder.toUriString(), HttpMethod.GET, requestEntity, TransactionList.class);
            transactionList = response.getBody();
        } catch (Exception e) {
            logger.error("Errore durante la chiamata sendMoneyTransfer: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return transactionList;
    }
}
