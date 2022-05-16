package com.mahkib.Sales_tax.services;

import com.mahkib.Sales_tax.constants.ProductType;
import com.mahkib.Sales_tax.interfaces.OrderEntry;
import com.mahkib.Sales_tax.interfaces.TaxEligibilityCheck;
import com.mahkib.Sales_tax.models.Tax;

import java.util.List;

public class TaxExemptionEligibilityCheck implements TaxEligibilityCheck {

	public static TaxExemptionEligibilityCheck exempt(ProductType... types) {
		return new TaxExemptionEligibilityCheck(types);
	}

	private final List<ProductType> types;

	private TaxExemptionEligibilityCheck(ProductType[] types) {
		this.types = List.of(types);
	}

	@Override
	public boolean isEligible(Tax tax) {
		return false;
	}

	@Override
	public boolean isEligible(OrderEntry entry) {
		return !types.contains(entry.getProducts().getType());
	}

}