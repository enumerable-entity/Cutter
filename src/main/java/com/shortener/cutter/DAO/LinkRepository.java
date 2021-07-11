package com.shortener.cutter.DAO;

import com.shortener.cutter.models.Link;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends CrudRepository<Link,Long> {
    Optional<Link> findByShortLink(String shortLink);
}
