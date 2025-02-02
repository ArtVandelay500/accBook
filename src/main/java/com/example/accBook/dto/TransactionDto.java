package com.example.accBook.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TransactionDto {

    private LocalDate date;
    private LocalTime time;
    private String store;
    private Double amount;
    private String memo;

    public TransactionDto(LocalDate date, LocalTime time, String store, Double amount, String memo) {
        this.date = date;
        this.time = time;
        this.store = store;
        this.amount = amount;
        this.memo = memo;
    }
}
