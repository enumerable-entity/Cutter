package com.shortener.cutter.controllers;

import com.shortener.cutter.DAO.LinkRepository;
import com.shortener.cutter.models.Link;
import com.shortener.cutter.services.LinkCutter;
import com.shortener.cutter.services.LinkPreparator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class LinkController {
    @Autowired
    LinkPreparator linkPreparator;
    @Autowired
    LinkRepository linkRepository;
    @Autowired
    LinkCutter linkCutter;

    @GetMapping("/")
    String getHomePage(){
    return "index";
    }

    @PostMapping("/")
    ModelAndView cutLink (@ModelAttribute("link") String link, Model model){
        var mav = new ModelAndView();
        String fullLink = linkPreparator.addLinkSchemaIfNotPresent(link);
        String shortedLink = linkCutter.getShortLink(fullLink);
        String preparedLink = linkPreparator.prepareShortLink(fullLink);
        mav.setViewName("cutted");
        mav.addObject("link",preparedLink);
        if(!linkRepository.existsByShortLink(shortedLink)) {
            linkRepository.save(new Link(fullLink, shortedLink, LocalDateTime.now(), LocalDateTime.now()));
        }
        return mav;
    }

}
