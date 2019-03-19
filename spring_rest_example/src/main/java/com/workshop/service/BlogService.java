package com.workshop.service;

import com.workshop.entity.Entry;
import com.workshop.model.BlogEntry;
import com.workshop.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public BlogEntry getBlogEntry(Long id) {
        return blogRepository.findById(id)
                .map(entry -> new BlogEntry(entry.getId(),
                        entry.getTitle(), entry.getContent()))
                .orElse(null);
    }

    public void addBlogEntry(BlogEntry blogEntry) {
        blogRepository.save(new Entry(blogEntry.getTitle(), blogEntry.getContent()));
    }
}
