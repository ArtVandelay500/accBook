package com.example.accBook.api.http;

import com.example.accBook.api.balance.BalanceApiResponse;
import com.example.accBook.api.transaction.TransactionApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpService {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Fetches data from the Balance API and maps it to BalanceApiResponse.
     *
     * @param url API URL
     * @return BalanceApiResponse
     */
    public BalanceApiResponse fetchBalanceData(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), BalanceApiResponse.class);
            } else {
                throw new RuntimeException("Balance API call failed with HTTP status: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch balance data", e);
        }
    }

    /**
     * Fetches data from the Transaction API and maps it to TransactionApiResponse.
     *
     * @param url API URL
     * @return TransactionApiResponse
     */
    public TransactionApiResponse fetchTransactionData(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), TransactionApiResponse.class);
            } else {
                throw new RuntimeException("Transaction API call failed with HTTP status: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch transaction data", e);
        }
    }
}
