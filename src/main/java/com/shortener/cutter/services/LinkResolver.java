package com.shortener.cutter.services;

import com.shortener.cutter.DAO.LinkRepository;
import com.shortener.cutter.models.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkResolver {
    LinkRepository linkRepository;

    LinkResolver(LinkRepository linkRepository){
        this.linkRepository=linkRepository;
    }
    public Optional<Link> resolve (String shortedLink){
        return linkRepository.findByShortLink(shortedLink);
    }
}
