package com.example.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.resources.util.URL;
import com.example.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<UserDTO>> findAll() {
////		User maria = new User("1", "Maria Silvia", "maria@gmail.com");
////		User alex = new User("2", "Alex Silvia", "alex@gmail.com");
//
//		List<User> list = service.findAll();
//		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//
//		// list.addAll(Arrays.asList(maria, alex));
//		return ResponseEntity.ok().body(listDto);
//		// return list;
//	}
	
	@RequestMapping(value = "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/titlesearch",  method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
//		User obj = service.fromDTO(objDTO);
//		obj = service.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@RequestMapping(value = "/{id}",  method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable String id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDTO) {
//		User obj = service.fromDTO(objDTO);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@RequestMapping(value = "/{id}/posts",  method = RequestMethod.GET)
//	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
//		User obj = service.findById(id);
//		return ResponseEntity.ok().body(obj.getPosts());
//	}
}
