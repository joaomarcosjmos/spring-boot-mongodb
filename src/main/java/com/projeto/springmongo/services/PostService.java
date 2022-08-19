package com.projeto.springmongo.services;

import com.projeto.springmongo.domain.Post;
import com.projeto.springmongo.domain.User;
import com.projeto.springmongo.dto.UserDTO;
import com.projeto.springmongo.repository.PostRepository;
import com.projeto.springmongo.repository.UserRepository;
import com.projeto.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        var post = repository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Object Not Found");
        }
        return post.get();
    }
}
