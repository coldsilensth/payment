package com.example.paymentManager.entity;

import com.example.paymentManager.enums.Currency;
import com.example.paymentManager.enums.State;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "payment_table")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    private Long id;
    private int amount;
    private String code;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private State state;
    private String namePay;

    public Payment(Long id, int amount, Currency currency, State state) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.state = state;
    }
}
