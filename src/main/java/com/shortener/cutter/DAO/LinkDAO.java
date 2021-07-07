package com.shortener.cutter.DAO;

import com.shortener.cutter.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkDAO extends CrudRepository<Link, Long> {



}
