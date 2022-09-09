package com.aglcropsystem.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paymentdeatils")
public class Payment {

	@Id
	private String transactionId;

	@NotNull(message = "Card number should not be empty")
	@Size(min=16,max=16,message="Card Number should of 16 digits")
	private String cardNumber;

	@NotNull(message = "Card type should not be empty")
	private String cardType;

	@NotNull(message = "Bank name should not be empty")
	private String bankName;

	@NotNull(message = "Amount should not be empty")
	private double amount;

	private String description;

	@NotNull(message = "Payment Date should not be empty")
	private String paymentDate;

	@NotNull(message = "Dealer Id should not be empty")
	private String dealerId;

	@NotNull(message = "Crop name should not be empty")
	private String cropName;

	public Payment() {

	}

	public Payment(String transactionId,
			@NotNull(message = "Card number should not be empty") @Size(min = 16, max = 16, message = "Card Number should of 16 digits") String cardNumber,
			@NotNull(message = "Card type should not be empty") String cardType,
			@NotNull(message = "Bank name should not be empty") String bankName,
			@NotNull(message = "Amount should not be empty") double amount, String description,
			@NotNull(message = "Payment Date should not be empty") String paymentDate,
			@NotNull(message = "Dealer Id should not be empty") String dealerId,
			@NotNull(message = "Crop name should not be empty") String cropName) {
		super();
		this.transactionId = transactionId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.bankName = bankName;
		this.amount = amount;
		this.description = description;
		this.paymentDate = paymentDate;
		this.dealerId = dealerId;
		this.cropName = cropName;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", bankName=" + bankName + ", amount=" + amount + ", description=" + description + ", paymentDate="
				+ paymentDate + ", dealerId=" + dealerId + ", cropName=" + cropName + "]";
	}

	


}