package com.dians.museumapi.services.XMLparsing;

import com.dians.museumapi.models.Museum;

public class AddressParsing implements ParsingStrategy{
    @Override
    public void parseKey(String value, Museum museum) {
        museum.setAddress(value);
    }
}
