package com.shortener.cutter.controllers;

import com.shortener.cutter.DAO.LinkRepository;
import com.shortener.cutter.models.Link;
import com.shortener.cutter.services.LinkCutter;
import com.shortener.cutter.services.LinkPreparator;
import org.springframework.beans.factory.annotation.Autowired;

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
    String homePage(){
    return "index";
    }

    @PostMapping("/")
    ModelAndView cutLink (@ModelAttribute("link") String link, Model model){
        var mav = new ModelAndView();
        String preparedLink = linkPreparator.prepareShortLink(link);
        String shortedLink = linkCutter.getShortLink(link);
        mav.setViewName("cutted");
        mav.addObject("link",preparedLink);

        linkRepository.save(new Link(link,shortedLink, LocalDateTime.now(),LocalDateTime.now()));
        return mav;
    }

}
