package com.example.paymentManager.dto;

import com.example.paymentManager.enums.Currency;
import com.example.paymentManager.enums.State;

import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private int amount;
    private String code;
    private Currency currency;
    private State state;
    private String namePay;

}
