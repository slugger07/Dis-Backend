package sgsits.cse.dis.administration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.feignClient.AcademicsClient;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.response.AddBookResponse;
import sgsits.cse.dis.administration.response.AddThesisResponse;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;
import sgsits.cse.dis.administration.serviceImpl.LibraryServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/library")
@Api(value = "Library")
public class LibraryController {
	
	@Autowired
	LibraryServicesImpl libraryServicesImpl;
	
	@Autowired
	AcademicsClient academicsClient;
	
	@ApiOperation(value="Add a book", response = AddBookResponse.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_BOOK, produces = "application/json")
	public AddBookResponse addBook(@RequestBody AddBookForm addBookForm) throws ConflictException {
		String bookId;
		try{
			bookId=libraryServicesImpl.addBook(addBookForm);
		}catch(ConflictException e){
			e.printStackTrace();
			throw new ConflictException("No records updated. This due to conflict in information on client side.");
		}
			return new AddBookResponse(" Book added successfully. Please note book's id ",bookId);
	}
	
	@ApiOperation(value="Get all books", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ALL_BOOKS, produces = "application/json")
	public List<LibraryBookRecords> getAllBooks(){
		return libraryServicesImpl.getAllBooks();	
	}
	
	@ApiOperation(value="Get book by title", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_TITLE, produces = "application/json")
	public List<LibraryBookRecords> getBookByTitle(@PathVariable("title") String title) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		try {
			libraryBookRecords = libraryServicesImpl.getBookByTitle(title);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Book with Title ["+title+"] doesn't exist.");
		}
		return libraryBookRecords;
	}
	
	@ApiOperation(value="Get book by book id", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_BOOK_ID, produces = "application/json")
	public List<LibraryBookRecords> getBookByBookId(@PathVariable("bookId") String bookId) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		try {
			libraryBookRecords = libraryServicesImpl.getBookByBookId(bookId);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Book with book id ["+bookId+"] doesn't exist.");
		}
		return libraryBookRecords;
	}
	
	
	@ApiOperation(value="Get book by author name", response = LibraryBookRecordsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_AUTHOR_NAME, produces = "application/json")
	public List<LibraryBookRecords> getBookByAuthorName(@PathVariable("authorName") String authorName) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		try {
			libraryBookRecords = libraryServicesImpl.getBookByAuthorName(authorName);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Book with author name ["+authorName+"] doesn't exist.");
		}
				
		return libraryBookRecords;
	}
	
	@ApiOperation(value="Get subject categry acronyms", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_SUBJECT_CATEGORY_LIST, produces = "application/json")
	public List<String> getSubjectCatergoryAcronymList(){
		return academicsClient.getAllSubjectAcronym();
	}
	
	@ApiOperation(value="Update a book", response = AddBookResponse.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path=RestAPI.UPDATE_BOOK, produces = "application/json")
	public AddBookResponse updateBook(@PathVariable("bookId") String bookId,@RequestBody AddBookForm addBookForm) throws ConflictException,EventDoesNotExistException{

		try{
			libraryServicesImpl.updateBook(addBookForm,bookId);
		}catch(ConflictException e){
			e.printStackTrace();
			throw new ConflictException("Book with book id: "+bookId+" couldn't be updated.");
		}
		catch(EventDoesNotExistException e)
		{
			e.printStackTrace();
			throw new EventDoesNotExistException("Book with book id ["+bookId+"] not found.");
		}
			return new AddBookResponse("Book updated successfully with book id: ",bookId);
	}
	
	@ApiOperation(value="delete a book", response = AddBookResponse.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path=RestAPI.DELETE_BOOK, produces = "application/json")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") String bookId) throws ConflictException,EventDoesNotExistException{

		try{
			libraryServicesImpl.deleteBook(bookId);
		}catch(EventDoesNotExistException e){
			e.printStackTrace();
			throw new EventDoesNotExistException("Book with book id: "+bookId+" doesn't exist.");
		}
		catch(ConflictException e)
		{
			e.printStackTrace();
			throw new ConflictException("Unable to delete book with book id: "+bookId+".");
		}
			return new ResponseEntity<String>(new String("Book with book id:  ["+bookId+"] deleted successfully. "),HttpStatus.OK);
	}
	
	
	//THESIS Services
	@ApiOperation(value="Add a thesis", response= AddThesisResponse.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path=RestAPI.ADD_THESIS, produces= "application/json")
	public AddThesisResponse addThesis(@RequestBody AddThesisForm addThesisForm) throws ConflictException {
		
		Long thesisId; 
		try {
			thesisId = libraryServicesImpl.addThesis(addThesisForm);
		} catch (ConflictException e)
		{
			e.printStackTrace();
			throw new ConflictException("No records updated. This is due to conflict in information on client side.");
		}
		    return new AddThesisResponse("Thesis added successfully. Please note Thesis id ", thesisId);
		
	}
	
	@ApiOperation(value="Get all thesis", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_ALL_THESIS, produces = "application/json")
	public List<LibraryThesisRecords> getAllThesis() {
		return libraryServicesImpl.getAllThesis();
	}
	
	@ApiOperation(value="Get thesis by title", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_TITLE, produces = "application/json")
	public List<LibraryThesisRecords> getThesisByTitle(@PathVariable("title") String title) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		try {
			libraryThesisRecords = libraryServicesImpl.getThesisByTitle(title);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with title ["+title+"] doesn't exist.");
		}
		return libraryThesisRecords;
	}
	
	@ApiOperation(value="Get thesis by submitted by", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_SUBMITTED_BY, produces = "application/json")
	public List<LibraryThesisRecords> getThesisBySubmittedBy(@PathVariable("submittedBy") String submittedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		try {
			libraryThesisRecords = libraryServicesImpl.getThesisBySubmittedBy(submittedBy);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with submitted by ["+submittedBy+"] doesn't exist.");
		}
		return libraryThesisRecords;
	}
	
	@ApiOperation(value="Get thesis by guided by", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_GUIDED_BY, produces = "application/json")
	public List<LibraryThesisRecords> getThesisByGuidedBy(@PathVariable("guidedBy") String guidedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		try {
			libraryThesisRecords = libraryServicesImpl.getThesisByGuidedBy(guidedBy);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with guided by ["+guidedBy+"] doesn't exist.");
		}
		return libraryThesisRecords;
	}
	
	@ApiOperation(value="Get thesis by thesis id", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_THESIS_ID, produces = "application/json")
	public List<LibraryThesisRecords> getThesisByThesisId(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		try {
			libraryThesisRecords = libraryServicesImpl.getThesisByThesisId(thesisId);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with thesis id ["+thesisId+"] doesn't exist.");
		}
		return libraryThesisRecords;
	}
	
	@ApiOperation(value="Get thesis by course", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_COURSE, produces = "application/json")
	public List<LibraryThesisRecords> getThesisByCourse(@PathVariable("course") String course) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		try {
			libraryThesisRecords = libraryServicesImpl.getThesisByCourse(course);
		} catch (EventDoesNotExistException e) {
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with thesis id ["+course+"] doesn't exist.");
		}
		return libraryThesisRecords;
	}
	
	@ApiOperation(value="Update a thesis", response = AddBookResponse.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path=RestAPI.UPDATE_THESIS, produces = "application/json")
	public AddThesisResponse updateThesis(@PathVariable("thesisId") long thesisId,@RequestBody AddThesisForm addThesisForm) throws EventDoesNotExistException,ConflictException{

		try{
			libraryServicesImpl.updateThesis(addThesisForm,thesisId);
		}catch(EventDoesNotExistException e){
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with thesis id ["+thesisId+"] not found.");
		}
		catch(ConflictException e) {
			e.printStackTrace();
			throw new ConflictException("Thesis with thesis id ["+thesisId+"] couldn't be updated");
			
		}
			return new AddThesisResponse("Thesis updated successfully with thesis id: ",thesisId);
	}
	

	@ApiOperation(value="delete a thesis", response = AddBookResponse.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path=RestAPI.DELETE_THESIS, produces = "application/json")
	public ResponseEntity<String> deleteThesis(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException,ConflictException{

		try{
			libraryServicesImpl.deleteThesis(thesisId);
		}catch(EventDoesNotExistException e){
			e.printStackTrace();
			throw new EventDoesNotExistException("Thesis with thesis id: "+thesisId+" doesn't exist.");
		}
		catch(ConflictException e) {
			e.printStackTrace();
			throw new ConflictException("Unable to delete thesis with thesis id: "+thesisId+".");
		}
			return new ResponseEntity<String>(new String("Thesis with thesis id: ["+thesisId+"] deleted successfully. "),HttpStatus.OK);
	}
	
	
}
