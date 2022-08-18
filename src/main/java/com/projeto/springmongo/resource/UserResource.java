package com.projeto.springmongo.resource;

import com.projeto.springmongo.domain.User;
import com.projeto.springmongo.dto.UserDTO;
import com.projeto.springmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
