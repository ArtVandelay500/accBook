package com.example.accBook.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class LedgerEntryDTO {
    private LocalDateTime dateTime;
    private BigDecimal amount;
    private String description;
}
