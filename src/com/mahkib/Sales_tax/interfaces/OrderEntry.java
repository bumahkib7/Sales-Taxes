package com.mahkib.Sales_tax.interfaces;

import com.mahkib.Sales_tax.models.Money;
import com.mahkib.Sales_tax.models.Products;

public interface OrderEntry {
	Products getProducts();
	Money getAmount();

}
