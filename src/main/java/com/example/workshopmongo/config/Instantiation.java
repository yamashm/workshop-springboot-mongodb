package com.example.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Itaúnas. Abraços!", mariaS);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei triste hoje!", mariaS);
		
		userReposiroty.saveAll(Arrays.asList(mariaS, alexS, maria, alex, bob));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

	
}
