package com.projeto.springmongo.dto;

import com.projeto.springmongo.domain.User;

public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(){
    }

    public AuthorDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static AuthorDTO convert(User user){
        AuthorDTO userDTO = new AuthorDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
