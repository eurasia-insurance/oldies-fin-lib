package com.lapsa.fin;

import java.util.Currency;

public enum FinCurrency implements FinLocalizationBundleBase {
    KZT("₸"),
    USD("$"),
    EUR("€"),
    RUB(null), // is not available in standart unicode fonts for now 21.07.2016
    ;

    private final Currency currency;
    private final String symbol;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private FinCurrency(String symbol) {
	this.currency = Currency.getInstance(this.name());
	this.symbol = symbol;
    }

    public int getNumericCode() {
	return currency.getNumericCode();
    }

    public String getSymbol() {
	if (symbol != null)
	    return symbol;
	return currency.getSymbol();
    }

    public static final FinCurrency byNumericCode(int numericCode) {
	for (FinCurrency fc : FinCurrency.values())
	    if (fc.getNumericCode() == numericCode)
		return fc;
	return null;
    }
}
