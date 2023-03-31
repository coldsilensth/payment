package com.example.paymentManager.service;

import com.example.paymentManager.dto.PaymentDto;
import com.example.paymentManager.entity.Payment;
import com.example.paymentManager.enums.Currency;
import com.example.paymentManager.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class PaymentService {
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }

    public Payment updatePayment(PaymentDto paymentDto) {
        Payment existingPayment = getPaymentById(paymentDto.getId()).get();
        existingPayment.setAmount(paymentDto.getAmount());
        existingPayment.setCode(paymentDto.getCode());
        existingPayment.setCurrency(paymentDto.getCurrency());
        existingPayment.setCode(paymentDto.getCode());
        return paymentRepository.save(existingPayment);
    }


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 12;

    public static String generateCode() {
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            codeBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return codeBuilder.toString();
    }

    public Payment createPayment(Payment payment) {
        payment.setCode(generateCode());
        return paymentRepository.save(payment);
    }

    public int sumAmount(Currency currency){
        return paymentRepository.totalByCurrency("RUB");
    }

    public void getNamePayment(String name) {
        paymentRepository.findAllByNamePay(name);
    }

}




