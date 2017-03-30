package ru.mcc.rsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.rsa.mcc.Customer;
import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams9 {
	public static void main(String[] args) {
		/*
		 * Here is old-style Java code which
		 * filters invoices from specific customer,
		 * sorts by amount and finally extracts the first two IDs.
		 * It will be refactoring round a corner :-)
		 */
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		
		List<Invoice> oracleInvoices = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		List<Integer> firstTwoIds = new ArrayList<>();
		
		for (Invoice inv : invoices) {
			if (inv.getCustomerId() == Customer.ORACLE) {
				oracleInvoices.add(inv);
			}
		}
		
		DemoData.printDemoData(oracleInvoices);
		
		Collections.sort(oracleInvoices,
				new Comparator<Invoice>() {
			@Override
			public int compare(Invoice inv1, Invoice inv2) {
				return Double.compare(inv1.getAmount(), inv2.getAmount());
			}
		});
		
		for(Invoice inv: oracleInvoices) {
			ids.add(inv.getId());
		}
		
		for(int i = 0; i < 2; i++) {
			firstTwoIds.add(ids.get(i));
		}
		
		for(int i = 0; i < firstTwoIds.size(); i++) {
			System.out.println("Invoice Id: " + firstTwoIds.get(i));
		}
	}

}
