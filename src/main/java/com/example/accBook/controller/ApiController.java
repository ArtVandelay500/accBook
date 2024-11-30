package com.example.accBook.controller;

import com.example.accBook.api.balance.BalanceApiResponse;
import com.example.accBook.api.config.ApiConfig;
import com.example.accBook.api.http.HttpService;
import com.example.accBook.api.transaction.TransactionApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final HttpService httpService;
    private final ApiConfig config;

    @Autowired
    public ApiController(ApiConfig config,HttpService httpService){
        this.httpService = httpService;
        this.config = config; // Replace with your actual API configuration
    }
    @GetMapping("/balance")
    public ResponseEntity<BalanceApiResponse> getBalance() {
        String balanceApiUrl = "https://your-balance-api-endpoint.com"; // Replace with the actual URL
        BalanceApiResponse balanceData = httpService.fetchBalanceData(balanceApiUrl);
        return ResponseEntity.ok(balanceData);
    }

    @GetMapping("/transactions")
    public ResponseEntity<TransactionApiResponse> getTransactions() {
        String transactionApiUrl = "https://your-transaction-api-endpoint.com"; // Replace with the actual URL
        TransactionApiResponse transactionData = httpService.fetchTransactionData(transactionApiUrl);
        return ResponseEntity.ok(transactionData);
    }

    @PostMapping("/result")
    public ResponseEntity<String> postResult() {
        String url = "https://testapi.openbanking.or.kr/oauth/2.0/token"; // Target URL

        // Add parameters for the POST body
        String code = config.getClient_code();
        String client_id = config.getClient_id();
        String client_secret = config.getClient_secret();
        String redirect_uri = "http://localhost:8080/api/result";
        String grant_type = "authorization_code";

        // Prepare the request body as a key-value string
        String requestBody = String.format(
                "code=%s&client_id=%s&client_secret=%s&redirect_uri=%s&grant_type=%s",
                code, client_id, client_secret, redirect_uri, grant_type);

        // Set headers for the POST request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded"); // Form data

        // Create an HttpEntity containing headers and body
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Send the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // Log the full URL for debugging
        System.out.println("POST Request Sent to: " + url);
        System.out.println("Request Body: " + requestBody);

        return ResponseEntity.ok(response.getBody());
    }
}
