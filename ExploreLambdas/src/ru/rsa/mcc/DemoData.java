package ru.rsa.mcc;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
	
	public static final List<Invoice> populateDemoData() {
		List<Invoice> lst = new ArrayList<>();
		lst.add(new Invoice(new Integer(1), new Integer(10), "Oracle", new Double(250.2)));
		lst.add(new Invoice(new Integer(2), new Integer(20), "Microsoft", new Double(150.1)));
		lst.add(new Invoice(new Integer(3), new Integer(30), "IBM", new Double(350.2)));
		lst.add(new Invoice(new Integer(4), new Integer(10), "Oracle", new Double(2500.2)));
		lst.add(new Invoice(new Integer(5), new Integer(20), "Microsoft", new Double(50.1)));
		lst.add(new Invoice(new Integer(6), new Integer(30), "IBM", new Double(3050.2)));
		return lst;
	}
	
	public static final void printDemoData(List<Invoice> invoices) {
		for (Invoice inv : invoices) {
			System.out.print("#: ");
			System.out.println(inv.getCustomerId());
			System.out.print("Name: ");
			System.out.println(inv.getCustomerName());
			System.out.print("Amount: ");
			System.out.println(inv.getAmount());
			System.out.println("--------------------------------------------");
		}
		System.out.println("==============================================");
	}
}
