package com.mahkib.Sales_tax.services;

import com.mahkib.Sales_tax.interfaces.OrderEntry;
import com.mahkib.Sales_tax.interfaces.TaxEligibilityCheck;
import com.mahkib.Sales_tax.models.Tax;

public class TaxImportedEligibilityCheck implements TaxEligibilityCheck {

	public static TaxImportedEligibilityCheck imported() {
		return new TaxImportedEligibilityCheck();
	}

	private TaxImportedEligibilityCheck() {}

	@Override
	public boolean isEligible(Tax tax) {
		return false;
	}

	@Override
	public boolean isEligible(OrderEntry entry) {
		return entry.getProducts().isImported();
	}

}