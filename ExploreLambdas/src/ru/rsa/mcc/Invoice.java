package ru.rsa.mcc;

public class Invoice {
	
	private Integer customerId;
	private String customerName;
	private Double amount;
	
	public Invoice(Integer customerId, String customerName, Double amount) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.amount = amount;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public static int compareByAmount(Invoice i1, Invoice i2) {
		return i1.getAmount().compareTo(i2.getAmount());
	}
}
