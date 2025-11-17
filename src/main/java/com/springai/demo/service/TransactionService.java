package com.springai.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springai.demo.entity.Transaction;
import com.springai.demo.entity.TransactionRepository;
import com.springai.demo.entity.dto.TransactionDto;
import com.springai.demo.entity.dto.TransactionSaveDto;
import com.springai.demo.entity.dto.TransactionUpdateDto;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto saveTransaction(TransactionSaveDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.amount());
        transaction.setDate(LocalDateTime.now());
        transaction.setType(transactionDto.type());
        transaction.setCategory(transactionDto.category());

        Transaction transactionResponse = transactionRepository.save(transaction);
        return new TransactionDto(transactionResponse.getId(), transactionResponse.getAmount(),
                transactionResponse.getDate(), transactionResponse.getType(), transactionResponse.getCategory());
    }

    public TransactionDto updateTransaction(long id, TransactionUpdateDto transactionDto) {
        Transaction transaction = transactionRepository.findById(id).get();
        
        if (transaction.getAmount() != transactionDto.amount()) {
            transaction.setAmount(transactionDto.amount());            
        }
        if (transaction.getCategory() != transactionDto.category()) {
            transaction.setCategory(transactionDto.category());            
        }

        Transaction transactionResponse = transactionRepository.save(transaction);
        return new TransactionDto(transactionResponse.getId(), transactionResponse.getAmount(),
                transactionResponse.getDate(), transactionResponse.getType(), transactionResponse.getCategory());
    }

    public TransactionDto getTransaction(long id) {
        Transaction transaction = transactionRepository.findById(id).get();
        return new TransactionDto(transaction.getId(), transaction.getAmount(),
                transaction.getDate(), transaction.getType(), transaction.getCategory());
    }

    public List<TransactionDto> getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> new TransactionDto(transaction.getId(), transaction.getAmount(),
                transaction.getDate(), transaction.getType(), transaction.getCategory())).toList();
    }

    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }

}
