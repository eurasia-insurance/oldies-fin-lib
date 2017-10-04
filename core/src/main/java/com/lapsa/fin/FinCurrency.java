package com.lapsa.fin;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Stream;

import com.lapsa.commons.elements.LocalizedElement;
import com.lapsa.commons.function.MyObjects;

public enum FinCurrency implements LocalizedElement {
    KZT(new Locale("kk", "KZ")), // "₸" is available on locale-kazakh.jar
    USD(Locale.US), // , "$"
    EUR(Locale.GERMANY), // , "€"
    RUB(new Locale("ru", "RU"), '\u20BD'), // is not available in standart
					   // unicode fonts at 21.07.2016
    ;

    //

    private final Currency currency;
    private final NumberFormat curencyNumberFormat;
    private final String customSymbol;

    //

    private FinCurrency(Locale locale) {
	MyObjects.requireNonNull(locale);
	this.currency = MyObjects.requireNonNull(Currency.getInstance(name()));
	this.curencyNumberFormat = MyObjects.requireNonNull(NumberFormat.getCurrencyInstance(locale));
	this.customSymbol = MyObjects.requireNonNull(currency.getSymbol(locale));
    }

    private FinCurrency(Locale locale, char customSymbol) {
	MyObjects.requireNonNull(locale);
	this.currency = MyObjects.requireNonNull(Currency.getInstance(name()));
	this.curencyNumberFormat = MyObjects.requireNonNull(NumberFormat.getCurrencyInstance(locale));
	this.customSymbol = String.valueOf(customSymbol);
    }

    //

    public static final Stream<FinCurrency> valuesStream() {
	return Stream.of(values());
    }

    //

    public static final FinCurrency byNumericCode(int numericCode) {
	return valuesStream() //
		.filter(x -> x.currency.getNumericCode() == numericCode) //
		.findAny() //
		.orElse(null);
    }

    //

    public String formatAmount(double value) {
	return curencyNumberFormat.format(value);
    }

    public String formatAmount(float value) {
	return curencyNumberFormat.format(value);
    }

    public String formatAmount(int value) {
	return curencyNumberFormat.format(value);
    }

    public String formatAmount(long value) {
	return curencyNumberFormat.format(value);
    }

    public <T extends Number> String formatAmount(T value) {
	return curencyNumberFormat.format(value);
    }

    // GENERATED

    public Currency getCurrency() {
	return currency;
    }

    public String getCustomSymbol() {
	return customSymbol;
    }
}
