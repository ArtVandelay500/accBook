package com.example.accBook.repository;

import com.example.accBook.entity.Transaction;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Id> {
    Optional<Transaction> findByDate(LocalDate date);
    Optional<Transaction> findByDateAndTimeAndStore(LocalDate date, LocalTime time, String store);
}
