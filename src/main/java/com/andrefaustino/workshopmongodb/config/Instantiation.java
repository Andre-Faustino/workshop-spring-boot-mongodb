package com.andrefaustino.workshopmongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andrefaustino.workshopmongodb.domain.Post;
import com.andrefaustino.workshopmongodb.domain.User;
import com.andrefaustino.workshopmongodb.dto.AuthorDTO;
import com.andrefaustino.workshopmongodb.dto.CommentDTO;
import com.andrefaustino.workshopmongodb.repositories.PostRepository;
import com.andrefaustino.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T00:00:00.00Z"), "Partiu Viagem!", "Vou Viajar pra São Paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.parse("2018-03-23T00:00:00.00Z"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		
		CommentDTO comm1 = new CommentDTO("Boa Viagem, Mano!", Instant.parse("2018-03-21T00:00:00.00Z"), new AuthorDTO(alex));
		CommentDTO comm2 = new CommentDTO("Aproveite!", Instant.parse("2018-03-22T00:00:00.00Z"), new AuthorDTO(bob));
		CommentDTO comm3 = new CommentDTO("Tenha um otimo dia!", Instant.parse("2018-03-23T00:00:00.00Z"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(comm1,comm2));
		post2.getComments().addAll(Arrays.asList(comm3));
								
		postRepo.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepo.save(maria);
		
		
		
	}

}
