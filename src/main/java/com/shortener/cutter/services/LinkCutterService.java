package com.shortener.cutter.services;

import org.springframework.stereotype.Service;

@Service
public interface LinkCutterService {

    String getShortLink (String url);

}
