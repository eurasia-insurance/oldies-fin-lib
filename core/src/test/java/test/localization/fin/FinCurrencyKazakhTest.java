package test.localization.fin;

import com.lapsa.fin.FinCurrency;

import test.localization.ElementsLocalizationTest;

public class FinCurrencyKazakhTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyKazakhTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_KAZAKH);
    }
}
