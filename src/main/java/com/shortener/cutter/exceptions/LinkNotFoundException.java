package com.shortener.cutter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException (String url){
        super("Link hash - \"" + url + "\" is not present");
    }
}
