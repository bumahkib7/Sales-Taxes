package com.mahkib.Sales_tax;


import com.mahkib.Sales_tax.models.Order;
import com.mahkib.Sales_tax.models.Products;
import com.mahkib.Sales_tax.models.Receipt;
import com.mahkib.Sales_tax.services.TaxMethod;
import com.mahkib.Sales_tax.services.TaxMethodsPractice;

import static com.mahkib.Sales_tax.constants.ProductOrigin.IMPORTED;
import static com.mahkib.Sales_tax.constants.ProductOrigin.LOCAL;
import static com.mahkib.Sales_tax.constants.ProductType.*;
import static com.mahkib.Sales_tax.models.Money.dollars;
import static com.mahkib.Sales_tax.services.TaxExemptionEligibilityCheck.exempt;
import static com.mahkib.Sales_tax.services.TaxImportedEligibilityCheck.imported;

public class Main {

	public static void main(String[] args) {


		// configure the system
		Products p1 = Products.create(1, "book", BOOK, LOCAL, dollars(String.valueOf(12.49)));
		Products p2 = Products.create(1, "music CD", MUSIC, LOCAL, dollars(String.valueOf(14.99)));
		Products p3 = Products.create(1, "chocolate bar", FOOD, LOCAL, dollars(String.valueOf(0.85)));
		Products p4 = Products.create(1, "imported box of chocolates", FOOD, IMPORTED, dollars(String.valueOf(10.00)));


		TaxMethod basicSalesTax = TaxMethod.create("BST", "0.10", exempt(BOOK, FOOD, MEDICAL));
		TaxMethod importDuty = TaxMethod.create("IMD", "0.05", imported());

		TaxMethodsPractice taxes = TaxMethodsPractice.create();

		taxes.add(basicSalesTax);
		taxes.add(importDuty);

		// purchase some items
		Order order = Order.create(taxes);
		order.add(p1, 3);
		order.add(p2, 10);
		order.add(p3, 4);
		order.add(p4, 5);

		// print the receipt
		Receipt receipt = Receipt.create(System.out);
		order.print(receipt);
	}

}