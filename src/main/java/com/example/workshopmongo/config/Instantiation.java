package com.example.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.AuthorDTO;
import com.example.workshopmongo.dto.CommentDTO;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		userReposiroty.deleteAll();
		postRepository.deleteAll();
		
		User mariaS = new User(null, "Maria Silva", "maria@gmail.com");
		User alexS = new User(null, "Alex Silva", "alex@gmail.com");
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(mariaS, alexS, maria, alex, bob));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Itaúnas. Abraços!",new AuthorDTO(mariaS));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei triste hoje!", new AuthorDTO(mariaS));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Espero que morra!", sdf.parse("23/03/2018"), new AuthorDTO(alexS));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		mariaS.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(mariaS);
	}

	
}
