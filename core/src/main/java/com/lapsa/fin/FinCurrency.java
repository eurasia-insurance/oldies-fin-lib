package com.lapsa.fin;

import java.util.Currency;

public enum FinCurrency implements FinLocalizationBundleBase {
    KZT("₸");

    private Currency currency;
    private String symbolOverride;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private FinCurrency(String symbolOverride) {
	this.symbolOverride = symbolOverride;
	this.currency = Currency.getInstance(this.name());
    }

    public int getNumericCode() {
	return currency.getNumericCode();
    }

    public String getSymbol() {
	if (symbolOverride != null)
	    return symbolOverride;
	return currency.getSymbol();
    }

    public static final FinCurrency byNumericCode(int numericCode) {
	for (FinCurrency fc : FinCurrency.values())
	    if (fc.getNumericCode() == numericCode)
		return fc;
	return null;
    }
}
