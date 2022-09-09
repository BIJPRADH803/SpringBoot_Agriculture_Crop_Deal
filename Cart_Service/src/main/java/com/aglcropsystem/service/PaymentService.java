package com.aglcropsystem.service;
import java.util.List;
import com.aglcropsystem.model.Payment;


public interface PaymentService {

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment getPaymentById(String transactionId);

}