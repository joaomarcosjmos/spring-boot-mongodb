package com.projeto.springmongo.config;

import com.projeto.springmongo.domain.Post;
import com.projeto.springmongo.domain.User;
import com.projeto.springmongo.dto.AuthorDTO;
import com.projeto.springmongo.dto.CommentDTO;
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

        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        var maria = new User(null, "Maria Brown", "maria@gmail.com");
        var alex = new User(null, "Alex Green", "alex@gmail.com");
        var bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex, bob));

        var post1 =new Post(null, sdf.parse("20/05/2022"), "Bom dia", "Acordei muito bem", new AuthorDTO(maria));
        var post2 =new Post(null, sdf.parse("30/01/2022"), "Boa noite", "Fui dormir muito bem", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("30/05/2022"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveitem!", sdf.parse("310/04/2022"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("30/05/2022"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.setPosts(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }
}
