package test.localization.fin;

import com.lapsa.fin.FinCurrency;

import test.localization.ElementsLocalizationTest;

public class FinCurrencyRussianTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyRussianTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_RUSSIAN);
    }
}
