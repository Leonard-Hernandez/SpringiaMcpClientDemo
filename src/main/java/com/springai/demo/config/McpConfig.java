package com.springai.demo.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springai.demo.controller.TransactionController;

@Configuration
public class McpConfig {

    @Bean
    ToolCallbackProvider transactionTools(TransactionController transactionController) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(transactionController)
                .build();
    }

}
