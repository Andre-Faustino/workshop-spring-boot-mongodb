package com.andrefaustino.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.andrefaustino.workshopmongodb.domain.User;
import com.andrefaustino.workshopmongodb.dto.UserDTO;
import com.andrefaustino.workshopmongodb.repositories.UserRepository;
import com.andrefaustino.workshopmongodb.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> FindAll(){
		return repo.findAll();
	}
	
	public User FindById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
	}
	
	public User Insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		try {
			repo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
		//catch(DataIntegrityViolationException e) {
		//	throw new DatabaseException(e.getMessage());
		//}
	}
	
	public User update(String id, User obj) {
		
			Optional<User> entity = repo.findById(id);
			updateData(entity.get(),obj);
			return repo.save(entity.get());
		
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
