package com.shortener.cutter.DAO;

import com.shortener.cutter.models.Link;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkRepository extends CrudRepository<Link,Long> {

    List<Link> findAll ();
    Link save (Link link);

}
