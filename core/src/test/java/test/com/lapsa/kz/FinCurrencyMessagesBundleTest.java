package test.com.lapsa.kz;

import com.lapsa.fin.FinCurrency;

public class FinCurrencyMessagesBundleTest extends EnumTypeMessagesBundleTest<FinCurrency>{

    @Override
    protected FinCurrency[] getAllEnumValues() {
	return FinCurrency.values();
    }

    @Override
    protected String getBundleBaseName() {
	return FinCurrency.BUNDLE_BASENAME;
    }
}
