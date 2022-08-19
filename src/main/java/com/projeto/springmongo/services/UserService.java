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

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        var newUser = repository.findById(user.getId()).get();
        updateData(newUser, user);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User froDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }
}
