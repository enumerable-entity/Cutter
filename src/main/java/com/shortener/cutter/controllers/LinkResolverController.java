package com.shortener.cutter.controllers;

import com.shortener.cutter.services.LinkResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/res/{shortLink}")
public class LinkResolverController {
    @Autowired
    LinkResolver linkResolver;
    @GetMapping
    RedirectView resolveLink (@PathVariable String shortLink){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkResolver.resolve(shortLink).orElseThrow().getLink());
        return redirectView;
    }
}
