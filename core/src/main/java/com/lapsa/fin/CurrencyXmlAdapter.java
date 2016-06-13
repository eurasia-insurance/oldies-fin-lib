package com.lapsa.fin;

import java.rmi.UnmarshalException;
import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CurrencyXmlAdapter extends XmlAdapter<Integer, Currency> {

    @Override
    public Currency unmarshal(Integer v) throws Exception {
	if (v == null)
	    return null;
	for (Currency c : Currency.getAvailableCurrencies())
	    if (c.getNumericCode() == v)
		return c;
	throw new UnmarshalException(
		String.format("Can't unmarshall %1$s from '%2$s' int value. Not found", Currency.class.getSimpleName(),
			v));
    }

    @Override
    public Integer marshal(Currency v) throws Exception {
	if (v == null)
	    return null;
	return v.getNumericCode();
    }

}
