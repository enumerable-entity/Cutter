package com.shortener.cutter.services;

import org.springframework.stereotype.Component;

@Component
public class HashCodeLinkCutterImpl implements LinkCutter{

    @Override
    public String getShortLink(String url) {
        return String.valueOf(url.hashCode());
    }
}
