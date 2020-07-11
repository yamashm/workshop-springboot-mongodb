package com.example.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
//		User maria = new User("1", "Maria Silvia", "maria@gmail.com");
//		User alex = new User("2", "Alex Silvia", "alex@gmail.com");

		List<User> list = service.findAll();

		// list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
		// return list;
	}
}
