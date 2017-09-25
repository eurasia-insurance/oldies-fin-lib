package test.localization;

import com.lapsa.fin.FinCurrency;

public class FinCurrencyRussianTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyRussianTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_RUSSIAN);
    }
}
