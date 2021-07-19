package com.shortener.cutter.controllers;
import com.shortener.cutter.exceptions.LinkNotFoundException;
import com.shortener.cutter.services.LinkResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/r/{shortLink}")
public class LinkResolverController {
    @Autowired
    LinkResolver linkResolver;
    @GetMapping
    public String resolveLink (@PathVariable String shortLink){
        return "redirect:" + linkResolver.resolve(shortLink).orElseThrow(() -> new LinkNotFoundException(shortLink)).getLink();
}}
