package com.mahkib.Sales_tax.services;

import com.mahkib.Sales_tax.interfaces.TaxingPractice;
import com.mahkib.Sales_tax.models.Money;
import com.mahkib.Sales_tax.models.Tax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TaxMethodsPractice implements TaxingPractice {

	public static TaxMethodsPractice create() {
		return new TaxMethodsPractice();
	}

	private final List<TaxMethod> taxes = new ArrayList<TaxMethod>();

	private TaxMethodsPractice() {}

	public void add(TaxMethod tax) {
		taxes.add(tax);
	}

	@Override
	public Collection<Tax> apply(ProductsEntry entry) {
		List<Tax> entries = new ArrayList<Tax>();
		for (TaxMethod tax : taxes) {
			if (tax.isEligible(entry)) {
				Tax taxEntry = apply(tax, entry);
				entries.add(taxEntry);
			}
		}
		return entries;
	}

	private Tax apply(TaxMethod tax, ProductsEntry entry) {
		Money taxAmount = tax.calculate(entry.getAmount());
		return Tax.create(entry, tax, taxAmount);
	}

}