package com.shortener.cutter.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LinkPreparatorService {

    private LinkCutterService linkCutterService;

    @Value("${app.prefix}")
    private String prefix;

    @Value("${app.domain}")
    private String domain;


    LinkPreparatorService(LinkCutterService linkCutterService){
        this.linkCutterService = linkCutterService;
    }

    public String prepareShortLink(String url){
        return prefix + domain +"r/"+ linkCutterService.getShortLink(url);
    }
    public String addLinkSchemaIfNotPresent(String url){
        return (url.startsWith("http://") || url.startsWith("https://"))? url : "https://"+url;
    }
}
