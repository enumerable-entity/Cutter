package com.shortener.cutter.services;

import org.springframework.stereotype.Component;

@Component
public class Base26LinkCutterService implements LinkCutterService {

    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final int BASE = alphabet.length;


    private String convertToBase26(long hashCode){
        StringBuilder shortLink = new StringBuilder();

        while (hashCode > 0){
            shortLink.append(alphabet[(int) (hashCode % BASE)]);
            hashCode = hashCode/BASE;
        }
        return shortLink.toString();
    }

    @Override
    public String getShortLink(String url)
    {
        return convertToBase26(Integer.toUnsignedLong(url.hashCode()));
    }
}
