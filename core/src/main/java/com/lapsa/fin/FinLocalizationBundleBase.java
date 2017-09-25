package com.lapsa.fin;

import com.lapsa.commons.elements.LocalizedElement;

public interface FinLocalizationBundleBase extends LocalizedElement {
    public static final String BUNDLE_BASENAME = "FinLocalization";

    @Override
    default String getBundleBaseName() {
	return BUNDLE_BASENAME;
    }
}
