package com.lapsa.fin;

import java.util.Currency;
import java.util.Locale;

public enum FinCurrency implements FinLocalizationBundleBase {
    KZT("₸", Locale.forLanguageTag("kk"));

    private final Currency currency;
    private final String symbolOverride;
    private final Locale locale;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    private FinCurrency(String symbolOverride, Locale locale) {
	this.symbolOverride = symbolOverride;
	this.currency = Currency.getInstance(this.name());
	this.locale = locale;
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

    public Locale getLocale() {
	return locale;
    }

}
