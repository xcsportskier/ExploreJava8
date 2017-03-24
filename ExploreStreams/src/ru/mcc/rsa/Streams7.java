package ru.mcc.rsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.rsa.mcc.DemoData;
import ru.rsa.mcc.Invoice;

public class Streams7 {

	public static void main(String[] args) {
		List<Invoice> invoices = DemoData.populateDemoData();
		DemoData.printDemoData(invoices);
		/*
		 * It's also possible to group and reduce stream's input element
		 * Let's calculate a invoices summary amount by a customer
		 */
		Map<String, Double> totalAmountByCustomer = invoices.stream()
															.collect(Collectors.groupingBy(
																	 Invoice::getCustomerName,
																	 Collectors.reducing(
																			 0.0,
																			 Invoice::getAmount,
																			 Double::sum)));
		
		List<Map.Entry<String, Double>> totalAmountByCustomerList = new ArrayList<>(totalAmountByCustomer.entrySet());
		
		totalAmountByCustomerList.stream()
								 .forEach(g -> System.out.printf("Customer %s, total amount %f\n", g.getKey(), g.getValue()));
				
	}
}
