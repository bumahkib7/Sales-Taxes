package com.mahkib.Sales_tax.interfaces;

import com.mahkib.Sales_tax.models.Money;
import com.mahkib.Sales_tax.models.Tax;
import com.mahkib.Sales_tax.services.ProductsEntry;

public interface ReceiptInterface {
	void start();
	<ProductEntry> void printProduct(ProductEntry entry);

	public void printTax(Tax entry);

	void printProduct(ProductsEntry entry);




	void printSubTotal(Money subTotal);
	void printTaxTotal(Money taxTotal);
	void printTotal(Money total);
	void end();
}
