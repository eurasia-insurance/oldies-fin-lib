package com.lapsa.fin;

import java.rmi.UnmarshalException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FinCurrencyXmlAdapter extends XmlAdapter<Integer, FinCurrency> {

    @Override
    public FinCurrency unmarshal(Integer v) throws Exception {
	if (v == null)
	    return null;
	FinCurrency c = FinCurrency.byNumericCode(v);
	if (c == null)
	    throw new UnmarshalException(String.format("Can't unmarshall %1$s from '%2$s' int value. Not found",
		    FinCurrency.class.getSimpleName(), v));
	return c;
    }

    @Override
    public Integer marshal(FinCurrency v) throws Exception {
	if (v == null)
	    return null;
	return v.getNumericCode();
    }
}
