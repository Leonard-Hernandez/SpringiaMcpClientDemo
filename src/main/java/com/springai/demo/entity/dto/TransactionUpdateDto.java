package com.springai.demo.entity.dto;

public record TransactionUpdateDto(
    Long amount,
    String category
) {
}