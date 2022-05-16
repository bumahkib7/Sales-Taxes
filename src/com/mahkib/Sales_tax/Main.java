package com.mahkib.Sales_tax;


import com.mahkib.Sales_tax.constants.ProductOrigin;
import com.mahkib.Sales_tax.constants.ProductType;
import com.mahkib.Sales_tax.models.Order;
import com.mahkib.Sales_tax.models.Products;
import com.mahkib.Sales_tax.models.Receipt;
import com.mahkib.Sales_tax.services.TaxMethod;
import com.mahkib.Sales_tax.services.TaxMethodsPractice;

import java.util.Scanner;

import static com.mahkib.Sales_tax.constants.ProductOrigin.IMPORTED;
import static com.mahkib.Sales_tax.constants.ProductOrigin.LOCAL;
import static com.mahkib.Sales_tax.constants.ProductType.*;
import static com.mahkib.Sales_tax.models.Money.dollars;
import static com.mahkib.Sales_tax.services.TaxExemptionEligibilityCheck.exempt;
import static com.mahkib.Sales_tax.services.TaxImportedEligibilityCheck.imported;

public class Main {

	public static void main(String[] args) {

		/*Forever loop*/
		TaxMethod basicSalesTax = TaxMethod.create("BST", "0.10", exempt(BOOK, FOOD, MEDICAL));
		TaxMethod importDuty = TaxMethod.create("IMD", "0.05", imported());

		TaxMethodsPractice taxes = TaxMethodsPractice.create();

		taxes.add(basicSalesTax);
		taxes.add(importDuty);


		// DONE: Storing is not done well.
		Order order = Order.create(taxes);

		for (; ; ) {

			Scanner sc = new Scanner(System.in);
			ProductType productTypeFinal = null;
			ProductOrigin productOriginFinal = null;

			System.out.println("Enter status");
			String status = sc.next();
			if (status.equals("YES")) {
				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();
				System.out.print("Enter  Name: ");
				String name = sc.next();
				System.out.print("Enter product Type");
				String productType = sc.next();

				switch (productType) {
					case "BOOK" -> productTypeFinal = BOOK;
					case "MEDICAL" -> productTypeFinal = MEDICAL;
					case "MUSIC" -> productTypeFinal = MUSIC;
					case "OTHER" -> productTypeFinal = OTHER;
				}

				System.out.print("Enter product Origin");
				String productOrigin = sc.next();

				switch (productOrigin) {
					case "LOCAL" -> productOriginFinal = LOCAL;
					case "IMPORTED" -> productOriginFinal = IMPORTED;
				}

				System.out.print("Enter price: ");
				String price = sc.next();

				Products p = Products.create(quantity, name, productTypeFinal, productOriginFinal, dollars(String.valueOf(price)));
				order.add(p, quantity);

				System.out.println("Print receipt");
				String decide = sc.next();

				if (decide.equals("YES")) {

					Receipt receipt = Receipt.create(System.out);
					order.print(receipt);

					break;
				}

			} else {
				System.out.println("Program exited.");
				break;
			}
		}
	}
}