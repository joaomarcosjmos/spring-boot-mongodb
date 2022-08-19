package com.projeto.springmongo.resources;

import com.projeto.springmongo.domain.Post;
import com.projeto.springmongo.resources.util.URL;
import com.projeto.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByTitle(text));
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        return ResponseEntity.ok().body(service.fullSearch(text, min, max));
    }

}
