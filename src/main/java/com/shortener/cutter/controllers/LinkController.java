package com.shortener.cutter.controllers;

import com.shortener.cutter.DAO.LinkRepository;
import com.shortener.cutter.models.Link;
import com.shortener.cutter.services.LinkCutter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/cut")
public class LinkController {
    @Autowired
    LinkCutter linkCutter;
    @Autowired
    LinkRepository linkRepository;

    @PostMapping
    ModelAndView getCutted (@ModelAttribute("link") String link, Model model){
        var mav = new ModelAndView();

        String shortedLink = linkCutter.getShortLink(link);
        mav.setViewName("cutted");
        mav.addObject("link",shortedLink);
        System.out.println(link);
        Link linkFromDb = linkRepository.save(new Link(link,shortedLink, LocalDateTime.now(),LocalDateTime.now()));
        System.out.println("Here is link id: " + linkFromDb.getId());
        return mav;
    }

}
