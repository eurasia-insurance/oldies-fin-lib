package test.localization;

import com.lapsa.fin.FinCurrency;

public class FinCurrencyKazakhTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyKazakhTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_KAZAKH);
    }
}
