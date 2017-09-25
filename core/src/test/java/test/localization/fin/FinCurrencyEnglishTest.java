package test.localization.fin;

import com.lapsa.fin.FinCurrency;

import test.localization.ElementsLocalizationTest;

public class FinCurrencyEnglishTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyEnglishTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_ENGLISH);
    }
}
