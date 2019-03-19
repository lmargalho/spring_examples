package com.workshop.service;

import com.workshop.entity.Entry;
import com.workshop.repository.BlogRepository;
import com.workshop.model.BlogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public BlogEntry getBlogEntry(Long id) {

        Entry entry = blogRepository.getById(id);

        return new BlogEntry(entry.getId(), entry.getTitle(), entry.getContent());
    }
}
