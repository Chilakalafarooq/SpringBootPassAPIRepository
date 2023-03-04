package farooq.com.Pass.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import farooq.com.Pass.playload.PassDto;
import farooq.com.Pass.service.PassService;

@RestController
@RequestMapping("/api/pass")
public class PassController {
	private PassService passService;
	private  ModelMapper mapper;
	public PassController(PassService passService, ModelMapper mapper) {
		super();
		this.passService = passService;
		this.mapper = mapper;
	}
	// Insert Operatio API
	//http://localhost:8080/api/pass
	@PostMapping
	public ResponseEntity<Object> createallPass(@RequestBody PassDto  passDto  ){
		return new ResponseEntity<Object>(passService.createallPass(passDto),HttpStatus.CREATED);
		
	}
	
	//Read Operation API
	//http://localhost:8080/api/pass
	@GetMapping
	public List<PassDto> getAllPass(){
		return this.passService.getAllPass();
	}
	
	//Read Operation API ById
		//http://localhost:8080/api/pass/1
	@GetMapping("{id}")
	
	public ResponseEntity<Object> getById(@PathVariable("id")long id){
		return new ResponseEntity<Object>(passService.getById(id),HttpStatus.OK);
	}
	// Update Operation API ById
	//http://localhost:8080/api/pass/1
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateById(
			@PathVariable (value = "id")long id,
			@RequestBody PassDto  passDto){
		return new ResponseEntity<Object>(passService.updateById(id, passDto),HttpStatus.OK);
	}
	// Delete Operation API ById
		//http://localhost:8080/api/pass/1
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable(value = "id")long id){
		passService.deleteById(id);
		return new ResponseEntity<Object>("Pass entity deleted successfully.",HttpStatus.OK);
	}
	
	


}
