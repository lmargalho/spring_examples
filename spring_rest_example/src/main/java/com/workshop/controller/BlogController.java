package com.workshop.controller;

import com.workshop.service.BlogService;
import com.workshop.model.BlogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
//@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException() {
        return "NOK";
    }

    @GetMapping("/blogs")
    //@RequestMapping(path = "/blogs", method = RequestMethod.GET)
    public List<BlogEntry> getBlogs() {
        return Collections.emptyList();
    }

    @GetMapping("/blog/{id}")
    // /blog/1?withLastUpdateTime=true
    public ResponseEntity<BlogEntry> getBlogById(@PathVariable("id") Long id,
                                                 @RequestParam(name = "withLastUpdateTime", defaultValue = "false") Boolean withLastUpdateTime) {

        if (id.equals(0L)) {
            throw new RuntimeException("NOK");
            //return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        BlogEntry blogEntry = blogService.getBlogEntry(id);

        if (withLastUpdateTime) {
            blogEntry.setLastUpdated(LocalDateTime.now());
        }

        return new ResponseEntity<>(blogEntry, HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<Void> addBlogEntry(@RequestBody BlogEntry blogEntry){

        blogService.addBlogEntry(blogEntry);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
