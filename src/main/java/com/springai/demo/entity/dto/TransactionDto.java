package com.springai.demo.entity.dto;

import java.time.LocalDateTime;

public record TransactionDto(
    Long id,
    Long amount,
    LocalDateTime date,
    String type,
    String category
) {

}
