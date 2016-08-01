package test.com.lapsa.kz;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.fin.FinCurrency;
import com.lapsa.fin.FinLocalizationBundleBase;

public class MessagesBundleExceedTest extends BaseMessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = getLocale(LANG_RU);
	ResourceBundle resources = getResourceBundle(FinLocalizationBundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.fin.FinCurrency.KZT"),
		allOf(not(nullValue()), is("Казахстанский тенге")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = getLocale(LANG_KK);
	ResourceBundle resources = getResourceBundle(FinLocalizationBundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.fin.FinCurrency.KZT"),
		allOf(not(nullValue()), is("Қазақстандық теңге")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = getLocale(LANG_EN);
	ResourceBundle resources = getResourceBundle(FinLocalizationBundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources.getString("com.lapsa.fin.FinCurrency.KZT"), allOf(not(nullValue()), is("Kazakhstani tenge")));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    if (findByFullName(FinCurrency.values(), key) != null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is not present", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	    String shrt = String.format("%s.%s.short", c.getClass().getName(), c.name());
	    if (shrt.equals(key))
		return c;
	}
	return null;
    }
}
