package sgsits.cse.dis.administration.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.service.LibraryServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/library")
@Api(value = "Library")
public class LibraryController {
	
	@Autowired
	LibraryServices libraryServices;
	
	@PostMapping(path=RestAPI.ADD_BOOK, produces = "application/json")
	public ResponseEntity<?> addBook(@RequestBody AddBookForm addBookForm) {
		boolean test = libraryServices.addBook(addBookForm);
		if(test==true)
			return new ResponseEntity<>(new ResponseMessage(" Records updated successfully!"),HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage("No records updated"),HttpStatus.OK);
	}
	
	@GetMapping(path=RestAPI.GET_ALL_BOOKS, produces = "application/json")
	public List<LibraryBookRecordsResponse> getAllBooks(){
		return libraryServices.getAllBooks();
		
	}
	
}
