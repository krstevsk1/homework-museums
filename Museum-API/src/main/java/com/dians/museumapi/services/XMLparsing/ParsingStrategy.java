package com.dians.museumapi.services.XMLparsing;

import com.dians.museumapi.models.Museum;

public interface ParsingStrategy {
    void parseKey(String value, Museum museum);
}
