package com.projeto.springmongo.config;

import com.projeto.springmongo.domain.Post;
import com.projeto.springmongo.domain.User;
import com.projeto.springmongo.dto.AuthorDTO;
import com.projeto.springmongo.repository.PostRepository;
import com.projeto.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex, bob));

        Post post1 =new Post(null, sdf.parse("20/05/2022"), "Bom dia", "Acordei muito bem", new AuthorDTO(maria));
        Post post2 =new Post(null, sdf.parse("30/01/2022"), "Boa noite", "Fui dormir muito bem", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
