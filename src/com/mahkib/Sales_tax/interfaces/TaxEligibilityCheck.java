package com.mahkib.Sales_tax.interfaces;


import com.mahkib.Sales_tax.models.Tax;

public interface TaxEligibilityCheck {
	boolean isEligible(Tax tax);

	boolean isEligible(OrderEntry entry);
}
