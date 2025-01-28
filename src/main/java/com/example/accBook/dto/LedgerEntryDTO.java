package com.example.accBook.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Service
public class LedgerEntryDTO {
    private LocalDateTime dateTime;
    private BigDecimal amount;
    private String description;
}
