package com.mahkib.Sales_tax.interfaces;

import com.mahkib.Sales_tax.models.Tax;
import com.mahkib.Sales_tax.services.ProductsEntry;

import java.util.Collection;

public interface TaxingPractice {

	Collection<Tax> apply(ProductsEntry entry);



}
