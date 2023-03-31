package com.example.paymentManager.mapper;

import com.example.paymentManager.dto.PaymentDto;
import com.example.paymentManager.entity.Payment;

import java.util.List;


public interface PaymentMapper {
    PaymentDto entityToDto(Payment payment);

    List<PaymentDto> entityToDtoList(List<Payment> payment);

    Payment dtoToEntity(PaymentDto paymentDto);
}
