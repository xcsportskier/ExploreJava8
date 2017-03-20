package ru.rsa.mcc;

import java.util.ArrayList;
import java.util.List;

public class Lambda1 {

	private List<Invoice> invoices;

	public Lambda1(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public final List<Invoice> getInvoices() {
		return invoices;
	}

	public final List<Invoice> findInvoicesGreaterThanAmount(double amount) {
		List<Invoice> result = new ArrayList<>();
		for (Invoice inv : invoices) {
			if (inv.getAmount() > amount) {
				result.add(inv);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Lambda1 ld = new Lambda1(DemoData.populateDemoData());
		DemoData.printDemoData(ld.getInvoices());
		
		List<Invoice> findResult = ld.findInvoicesGreaterThanAmount(1900);
		
		DemoData.printDemoData(findResult);
	}

}
