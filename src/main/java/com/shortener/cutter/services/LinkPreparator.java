package com.shortener.cutter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LinkPreparator {

    private LinkCutter linkCutter;

    @Value("${app.prefix}")
    private String prefix;

    @Value("${app.domain}")
    private String domain;


    LinkPreparator(LinkCutter linkCutter){
        this.linkCutter=linkCutter;
    }

    public String prepareShortLink(String url){
        return prefix + domain +"res/"+ linkCutter.getShortLink(url);
    }
}
