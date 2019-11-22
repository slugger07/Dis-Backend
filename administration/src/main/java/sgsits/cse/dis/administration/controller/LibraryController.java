package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.exception.BookDoesNotExistException;
import sgsits.cse.dis.administration.feignClient.AcademicsClient;
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
	
	@Autowired
	AcademicsClient academicsClient;
	
	@ApiOperation(value="Add a book", response = ResponseEntity.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_BOOK, produces = "application/json")
	public ResponseEntity<?> addBook(@RequestBody AddBookForm addBookForm) {
		boolean test = libraryServices.addBook(addBookForm);
		if(test==true)
			return new ResponseEntity<>(new ResponseMessage(" Records updated successfully!"),HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage("No records updated"),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all books", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ALL_BOOKS, produces = "application/json")
	public List<LibraryBookRecordsResponse> getAllBooks(){
		return libraryServices.getAllBooks();	
	}
	
	@ApiOperation(value="Get books by title", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_TITLE, produces = "application/json")
	public List<LibraryBookRecordsResponse> getBookByTitle(@PathVariable("title") String title) throws BookDoesNotExistException{
		List<LibraryBookRecordsResponse> libraryBookRecordsResponses = libraryServices.getBookByTitle(title);
		if(libraryBookRecordsResponses.isEmpty()) {
			throw new BookDoesNotExistException("Book with Title: \""+title+"\" doesn't exist.");
		}
		return libraryBookRecordsResponses;
	}
	
	@ApiOperation(value="Get book by author name", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_AUTHOR_NAME, produces = "application/json")
	public List<LibraryBookRecordsResponse> getBookByAuthorName(@PathVariable("authorName") String authorName) throws BookDoesNotExistException{
		List<LibraryBookRecordsResponse> libraryBookRecordsResponses = libraryServices.getBookByAuthorName(authorName);
		if(libraryBookRecordsResponses.isEmpty()) {
			throw new BookDoesNotExistException("Book with author name \""+authorName+"\" doesn't exist.");
		}
		return libraryBookRecordsResponses;
	}
	
	@ApiOperation(value="Get subject categry acronyms", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_SUBJECT_CATEGORY_LIST, produces = "application/json")
	public List<String> getSubjectCatergoryAcronymList(){
		return academicsClient.getAllSubjectAcronym();
	}
	
}
