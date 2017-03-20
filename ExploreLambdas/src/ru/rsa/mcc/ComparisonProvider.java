package ru.rsa.mcc;

// declare ComparisionProvider class with instance method compareByAmount
public class ComparisonProvider {
	public int compareByAmount(Invoice i1, Invoice i2) {
		return i1.getAmount().compareTo(i2.getAmount());
	}
}
