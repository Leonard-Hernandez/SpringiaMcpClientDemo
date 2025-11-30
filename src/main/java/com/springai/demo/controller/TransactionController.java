package com.springai.demo.controller;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springai.demo.entity.dto.TransactionDto;
import com.springai.demo.entity.dto.TransactionSaveDto;
import com.springai.demo.entity.dto.TransactionUpdateDto;
import com.springai.demo.service.TransactionService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/get/{id}")
    @Tool(description = "getTransaction by id")
    public TransactionDto getTransaction(@PathParam("id") Long id) {
        return transactionService.getTransaction(id);
    }

    @GetMapping("/getAll")
    @Tool(description = "getAllTransactions")
    public List<TransactionDto> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping("/save")
    @Tool(description = "saveTransaction")
    public TransactionDto saveTransaction(@RequestBody TransactionSaveDto transactionDto) {
        return transactionService.saveTransaction(transactionDto);
    }

    @PutMapping("/update/{id}")
    @Tool(description = "updateTransaction")
    public TransactionDto updateTransaction(@PathParam("id") Long id, @RequestBody TransactionUpdateDto transactionDto) {
        return transactionService.updateTransaction(id, transactionDto);
    }

    @GetMapping("/delete/{id}")
    public void deleteTransaction(@PathParam("id") Long id) {
        transactionService.deleteTransaction(id);
    }

}
