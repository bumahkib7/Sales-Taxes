package com.mahkib.Sales_tax.models;

import com.mahkib.Sales_tax.services.ProductsEntry;
import com.mahkib.Sales_tax.interfaces.ReceiptInterface;
import lombok.ToString;

import java.io.PrintStream;

@ToString
public class Receipt implements ReceiptInterface {

	public static Receipt create(PrintStream out) {
		return new Receipt(out);
	}

	private final PrintStream out;

	private Receipt(PrintStream out) {
		this.out = out;
	}

	@Override
	public void start() {
		out.println("------------------ THIS IS YOUR ORDER ------------------");
	}

	@Override
	public <ProductEntry> void printProduct(ProductEntry productEntry) {

	}


	@Override
	public void printProduct(ProductsEntry entry) {
		out.printf("(%03d) %35s ----- %8s\n", entry.getQuantity(), entry.getProductName(), entry.getAmount());
	}

	@Override
	public void printTax(Tax entry) {
		out.printf("(%3s) %35s ----- %8s\n", entry.getTaxName(), entry.getProductName(), entry.getAmount());
	}

	@Override
	public void printSubTotal(Money subTotal) {
		out.printf("%41s ----- %8s\n", "SUB-TOTAL", subTotal);
	}

	@Override
	public void printTaxTotal(Money taxTotal) {
		out.printf("%41s ----- %8s\n", "TAX TOTAL", taxTotal);
	}

	@Override
	public void printTotal(Money total) {
		out.printf("%41s ----- %8s\n", "TOTAL", total);
	}

	@Override
	public void end() {
		out.println("---------------- THANKS FOR CHOOSING US ----------------");
	}
}
