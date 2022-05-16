package com.mahkib.Sales_tax.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.*;

@Getter
@Setter


public class Money {


	private static BigDecimal bigDecimal;


	public static Money dollars(String amount) {
		return new Money(bigDecimal, new BigDecimal(amount));
	}

	private final BigDecimal amount;

	private Money(BigDecimal bigDecimal, BigDecimal amount) {
		Money.bigDecimal = bigDecimal;
		this.amount = amount.setScale(2, RoundingMode.UP);
	}

	@Override public int hashCode() {
		return amount.hashCode();
	}

	@Override public boolean equals(Object other) {
		if (other == null) return false;
		return other instanceof Money && equals((Money)other);
	}

	public boolean equals(Money other) {
		return amount.equals(other.getAmount());
	}

	private BigDecimal getAmount() {
		return amount;
	}

	public Money add(Money other) {
		return new Money(bigDecimal, amount.add(other.amount));
	}

	public Money multiply(int times) {
		return multiply(new BigDecimal(times));
	}

	public Money multiply(String factor) {
		return multiply(new BigDecimal(factor));
	}

	public Money multiply(BigDecimal factor) {
		return new Money(bigDecimal, amount.multiply(factor));
	}

	@Override public String toString() {
		return "$" + amount;
	}


}
