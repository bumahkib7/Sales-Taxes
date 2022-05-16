package com.mahkib.Sales_tax.models;

import com.mahkib.Sales_tax.constants.ProductOrigin;
import com.mahkib.Sales_tax.constants.ProductType;


import lombok.*;


@ToString
@Getter
@Setter

public class Products {



	public static Products create(int quantity ,String name, ProductType type, ProductOrigin origin, Money price) {
		return new Products (quantity, name, type, origin, price);
	}

	private final String name;
	private final ProductType type;
	private final ProductOrigin origin;
	private final Money price;
	private final int quantity;

	private Products(int Quantity , String name, ProductType type, ProductOrigin origin, Money price) {
		this.name = name;
		this.type = type;
		this.origin = origin;
		this.price = price;
		this.quantity = Quantity;
	}

	public String getName() {
		return name;
	}

	public ProductType getType() {
		return type;
	}

	public Money getPrice() {
		return price;
	}

	public boolean isImported() {
		return origin == ProductOrigin.IMPORTED;
	}
}

