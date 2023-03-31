package com.example.paymentManager.controller;

import com.example.paymentManager.dto.PaymentDto;
import com.example.paymentManager.entity.Payment;
import com.example.paymentManager.enums.Currency;
import com.example.paymentManager.repository.PaymentRepository;
import com.example.paymentManager.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentService paymentService;



    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/getPaymentById/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(paymentDto);
    }
    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }
    @GetMapping("/amount/{currency}")
    public int amountt(@PathVariable Currency currency){
        return paymentService.sumAmount(currency);
    }


}

//назначение платежа