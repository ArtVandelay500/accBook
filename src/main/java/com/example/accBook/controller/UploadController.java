package com.example.accBook.controller;

import com.example.accBook.dto.TransactionDto;
import com.example.accBook.entity.Transaction;
import com.example.accBook.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    private final ExcelService excelService;

    // 생성자 주입
    public UploadController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        List<TransactionDto> transactions = excelService.readExcel(file);
        model.addAttribute("transactions", transactions);
        return "transactions";  // 업로드된 데이터를 보여주는 뷰
    }
}
