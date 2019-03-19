package com.workshop.repository;

import com.workshop.entity.Entry;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {

    public Entry getById(Long id) {
        return new Entry(1, "Demo", "Description");
    }
}
