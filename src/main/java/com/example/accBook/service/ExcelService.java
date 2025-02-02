package com.example.accBook.service;

import com.example.accBook.dto.TransactionDto;
import com.example.accBook.entity.Transaction;
import com.example.accBook.repository.TransactionRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExcelService {
    private final TransactionRepository transactionRepository;
    // 생성자 주입
    public ExcelService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // 엑셀 파일 읽기 및 DTO 변환
    public List<TransactionDto> readExcel(MultipartFile file) {
        List<TransactionDto> transactions = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;  // 헤더는 건너뜀

                LocalDate date = LocalDate.parse(row.getCell(0).getStringCellValue());
                LocalTime time = LocalTime.parse(row.getCell(1).getStringCellValue());
                String store = row.getCell(2).getStringCellValue();
                Double amount = row.getCell(3).getNumericCellValue();
                String memo = row.getCell(4).getStringCellValue();

                transactions.add(new TransactionDto(date, time, store, amount, memo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    // 중복 검사 및 저장 로직
    public String checkAndSaveTransaction(Transaction transaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findByDateAndTimeAndStore(
                transaction.getDate(), transaction.getTime(), transaction.getStore());

        if (existingTransaction.isPresent()) {
            return "중복된 거래가 발견되었습니다. 덮어쓰기를 선택해 주세요.";
        } else {
            transactionRepository.save(transaction);
            return "새 거래가 저장되었습니다.";
        }
    }
}
