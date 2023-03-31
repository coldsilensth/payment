package com.example.paymentManager.repository;

import com.example.paymentManager.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(nativeQuery = true, value = "SELECT sum(amount) from payment_table where currency = 'RUB'")
    int totalByCurrency(String currency);

    List<Payment> findAllByNamePay(String namePay);
}
