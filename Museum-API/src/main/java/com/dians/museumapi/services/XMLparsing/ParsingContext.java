package com.dians.museumapi.services.XMLparsing;

import com.dians.museumapi.models.Museum;

import java.util.HashMap;
import java.util.Map;

public class ParsingContext {
    private Map<String, ParsingStrategy> parseStrategyByKey;

    public ParsingContext() {
        this.parseStrategyByKey = new HashMap<>();
        this.parseStrategyByKey.put("name", new NameParsing());
        this.parseStrategyByKey.put("name:en", new NameParsing());
        this.parseStrategyByKey.put("addr:city:en", new CityParsing());
        this.parseStrategyByKey.put("addr:street", new AddressParsing());
        this.parseStrategyByKey.put("email", new EmailParsing());
        this.parseStrategyByKey.put("opening_hours", new WorkingHoursParsing());
        this.parseStrategyByKey.put("phone", new PhoneParsing());
        this.parseStrategyByKey.put("website", new WebsiteParsing());

    }

    public void parse(String key, String value, Museum m){
        ParsingStrategy strategy = parseStrategyByKey.get(key);
        if (strategy != null) {
            strategy.parseKey(value, m);
        }
    }

}
