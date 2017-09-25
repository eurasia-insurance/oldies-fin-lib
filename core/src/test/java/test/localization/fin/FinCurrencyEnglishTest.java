package test.localization;

import com.lapsa.fin.FinCurrency;

public class FinCurrencyEnglishTest extends ElementsLocalizationTest<FinCurrency> {

    public FinCurrencyEnglishTest() {
	super(FinCurrency.values(), FinCurrency.class, LOCALE_ENGLISH);
    }
}
