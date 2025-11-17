package com.springai.demo.entity.dto;

public record TransactionSaveDto(
    Long amount,
    String type,
    String category
) {

}
