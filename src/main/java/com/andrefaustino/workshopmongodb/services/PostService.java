package com.andrefaustino.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrefaustino.workshopmongodb.domain.Post;
import com.andrefaustino.workshopmongodb.repositories.PostRepository;
import com.andrefaustino.workshopmongodb.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post FindById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
		
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
}
