package com.projeto.springmongo.services;

import com.projeto.springmongo.domain.User;
import com.projeto.springmongo.dto.UserDTO;
import com.projeto.springmongo.repository.UserRepository;
import com.projeto.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        var users = repository.findAll();
        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public User findById(String id) {
        var user = repository.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Object Not Found");
        }
        return user.get();
    }
}
