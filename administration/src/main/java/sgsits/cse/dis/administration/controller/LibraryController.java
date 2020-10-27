package sgsits.cse.dis.administration.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.feignClient.AcademicsClient;
import sgsits.cse.dis.administration.model.LibraryBookCategoryCount;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.model.LibraryIssueHistory;
import sgsits.cse.dis.administration.model.LibrarySettings;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.repo.LibraryBookCategoryCountRepository;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.request.IssueForm;
import sgsits.cse.dis.administration.response.AddBookResponse;
import sgsits.cse.dis.administration.response.AddThesisResponse;
import sgsits.cse.dis.administration.response.IssuedInformationResponse;
import sgsits.cse.dis.administration.serviceImpl.LibraryServicesImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/library")
@Api(value = "Library")
public class LibraryController {
	
	@Autowired
	private LibraryServicesImpl libraryServicesImpl;
	
	@Autowired
	private LibraryBookCategoryCountRepository libraryBookCategoryCountRepository;
	
	@Autowired
	private AcademicsClient academicsClient;
	
	
	
	//Library Setting service
	
	@ApiOperation(value="Get library setting", response = LibrarySettings.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_LIBRARY_SETTINGS, produces = "application/json")
	public ResponseEntity<List<LibrarySettings>> getSettings() {
		return new ResponseEntity<List<LibrarySettings>>(libraryServicesImpl.getSetting(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Update library setting", response = String.class, httpMethod = "PUT", produces = "text/plain")
	@PutMapping(path=RestAPI.UPDATE_LIBRARY_SETTINGS, produces = "text/plain")
	public ResponseEntity<String>updateSettings(@RequestBody LibrarySettings librarySettings) throws EventDoesNotExistException {
		libraryServicesImpl.updateSettings(librarySettings);
		return new ResponseEntity<String>(new String("Setings Updated"),HttpStatus.OK);
		
	}

	//Books services
	
	@ApiOperation(value="Add a book", response = AddBookResponse.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_BOOK, produces = "application/json")
	public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookForm addBookForm) throws ConflictException {
		String bookId;
		bookId=libraryServicesImpl.addBook(addBookForm);
		return new ResponseEntity<AddBookResponse>(new AddBookResponse(" Book added successfully. Please note book's id ",bookId),HttpStatus.OK) ;
	}
	
	@ApiOperation(value="Get all books", response = LibraryBookRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ALL_BOOKS, produces = "application/json")
	public ResponseEntity<List<LibraryBookRecords>> getAllBooks(){
		return new ResponseEntity<List<LibraryBookRecords>>(libraryServicesImpl.getAllBooks(),HttpStatus.OK);	
	}
	
	@ApiOperation(value="Get book by title", response = LibraryBookRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_TITLE, produces = "application/json")
	public  ResponseEntity<List<LibraryBookRecords>> getBookByTitle(@PathVariable("title") String title) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		libraryBookRecords = libraryServicesImpl.getBookByTitle(title);
		return new ResponseEntity<List<LibraryBookRecords>>(libraryBookRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get book by book id", response = LibraryBookRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_BOOK_ID, produces = "application/json")
	public ResponseEntity<List<LibraryBookRecords>> getBookByBookId(@PathVariable("bookId") String bookId) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		libraryBookRecords = libraryServicesImpl.getBookByBookId(bookId);
		return new ResponseEntity<List<LibraryBookRecords>>(libraryBookRecords,HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Get book by author name", response = LibraryBookRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_BOOK_BY_AUTHOR_NAME, produces = "application/json")
	public ResponseEntity<List<LibraryBookRecords>> getBookByAuthorName(@PathVariable("authorName") String authorName) throws EventDoesNotExistException{
		List<LibraryBookRecords> libraryBookRecords = new ArrayList<LibraryBookRecords>();
		libraryBookRecords = libraryServicesImpl.getBookByAuthorName(authorName);
		return new ResponseEntity<List<LibraryBookRecords>>(libraryBookRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get subject category acronyms", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_SUBJECT_CATEGORY_LIST, produces = "application/json")
	public ResponseEntity<List<String>> getSubjectCatergoryAcronymList(){
		return new ResponseEntity<List<String>>(libraryServicesImpl.getSubjectCatergoryAcronymList(),HttpStatus.OK);
//		return new ResponseEntity<List<String>>(academicsClient.getAllSubjectAcronym(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Update a book", response = AddBookResponse.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path=RestAPI.UPDATE_BOOK, produces = "application/json")
	public ResponseEntity<AddBookResponse> updateBook(@PathVariable("bookId") String bookId,@RequestBody AddBookForm addBookForm) throws ConflictException,EventDoesNotExistException{
			libraryServicesImpl.updateBook(addBookForm,bookId);
			return new ResponseEntity<AddBookResponse>(new AddBookResponse("Book updated successfully with book id: ",bookId),HttpStatus.OK);
	}

	
	@ApiOperation(value="delete a book", response = String.class, httpMethod = "DELETE", produces = "text/plain")
	@DeleteMapping(path=RestAPI.DELETE_BOOK, produces = "text/plain")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") String bookId) throws EventDoesNotExistException, ConflictException{
			libraryServicesImpl.deleteBook(bookId);	
			return new ResponseEntity<String>(new String("Book with book id:  ["+bookId+"] deleted successfully. "),HttpStatus.OK);
	}
	
	@ApiOperation(value="delete a category", response = String.class, httpMethod = "DELETE", produces = "text/plain")
	@DeleteMapping(path=RestAPI.DELETE_CATEGORY, produces = "text/plain")
	public ResponseEntity<String> deleteCategory(@PathVariable("SubjectCategory") String subjectCategory) throws EventDoesNotExistException{
			libraryServicesImpl.deleteSubjectCategory(subjectCategory);	
			return new ResponseEntity<String>(new String("Category deleted successfully. "),HttpStatus.OK);
	}
	
	@ApiOperation(value="Add a book category", response = String.class, httpMethod = "POST", produces = "text/plain")
	@PostMapping(path=RestAPI.ADD_BOOK_CATEGORY, produces = "text/palin")
	public ResponseEntity<String> addBook(@RequestBody LibraryBookCategoryCount libraryBookCategoryCount) throws ConflictException {
		libraryServicesImpl.addNewSubjectCategory(libraryBookCategoryCount);
		return new ResponseEntity<String>(new String(" Category added successfully."),HttpStatus.OK) ;
	}
	
	@ApiOperation(value="Get Acronym by subject name", response = LibraryBookCategoryCount.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ACRONYM_BY_SUBJECT_NAME, produces = "application/json")
	public ResponseEntity<List<LibraryBookCategoryCount>> getAcronymBySubjectName(@PathVariable("subjectName") String subjectName) throws EventDoesNotExistException{
		List<LibraryBookCategoryCount> libraryBookCategoryCounts = new ArrayList<LibraryBookCategoryCount>();
		libraryBookCategoryCounts=libraryServicesImpl.getAcronymBySubjectName(subjectName);
		return new ResponseEntity<List<LibraryBookCategoryCount>>(libraryBookCategoryCounts,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Subject name by acromym", response = LibraryBookCategoryCount.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_SUBJECT_NAME_BY_ACRONYM, produces = "application/json")
	public ResponseEntity<List<LibraryBookCategoryCount>> getSubjectNameByAcronym(@PathVariable("acronym") String subjectCategory) throws EventDoesNotExistException{
		List<LibraryBookCategoryCount> libraryBookCategoryCounts = new ArrayList<LibraryBookCategoryCount>();
		libraryBookCategoryCounts=libraryServicesImpl.getSubjectNameByAcronym(subjectCategory);
		return new ResponseEntity<List<LibraryBookCategoryCount>>(libraryBookCategoryCounts,HttpStatus.OK);
	}
	
	//THESIS Services
	@ApiOperation(value="Add a thesis", response= AddThesisResponse.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path=RestAPI.ADD_THESIS, produces= "application/json")
	public ResponseEntity<AddThesisResponse> addThesis(@RequestBody AddThesisForm addThesisForm) throws ConflictException {
		Long thesisId; 
		thesisId = libraryServicesImpl.addThesis(addThesisForm);
		return new ResponseEntity<AddThesisResponse>(new AddThesisResponse("Thesis added successfully. Please note Thesis id ", thesisId),HttpStatus.OK) ;	
	}
	
	@ApiOperation(value="Get all thesis", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_ALL_THESIS, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getAllThesis() {
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryServicesImpl.getAllThesis(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get thesis by title", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_TITLE, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getThesisByTitle(@PathVariable("title") String title) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		libraryThesisRecords = libraryServicesImpl.getThesisByTitle(title);
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryThesisRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get thesis by submitted by", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_SUBMITTED_BY, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getThesisBySubmittedBy(@PathVariable("submittedBy") String submittedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		libraryThesisRecords = libraryServicesImpl.getThesisBySubmittedBy(submittedBy);
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryThesisRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get thesis by guided by", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_GUIDED_BY, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getThesisByGuidedBy(@PathVariable("guidedBy") String guidedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		libraryThesisRecords = libraryServicesImpl.getThesisByGuidedBy(guidedBy);
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryThesisRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get thesis by thesis id", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_THESIS_ID, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getThesisByThesisId(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		libraryThesisRecords = libraryServicesImpl.getThesisByThesisId(thesisId);
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryThesisRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get thesis by course", response = LibraryThesisRecords.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_THESIS_BY_COURSE, produces = "application/json")
	public ResponseEntity<List<LibraryThesisRecords>> getThesisByCourse(@PathVariable("course") String course) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords = new ArrayList<LibraryThesisRecords>();
		libraryThesisRecords = libraryServicesImpl.getThesisByCourse(course);
		return new ResponseEntity<List<LibraryThesisRecords>>(libraryThesisRecords,HttpStatus.OK);
	}
	
	@ApiOperation(value="Update a thesis", response = AddThesisResponse.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path=RestAPI.UPDATE_THESIS, produces = "application/json")
	public ResponseEntity<AddThesisResponse> updateThesis(@PathVariable("thesisId") long thesisId,@RequestBody AddThesisForm addThesisForm) throws EventDoesNotExistException,ConflictException{
		libraryServicesImpl.updateThesis(addThesisForm,thesisId);
		return new ResponseEntity<AddThesisResponse>(new AddThesisResponse("Thesis updated successfully with thesis id: ",thesisId),HttpStatus.OK);
	}
	

	@ApiOperation(value="delete a thesis", response = String.class, httpMethod = "DELETE", produces = "text/plain")
	@DeleteMapping(path=RestAPI.DELETE_THESIS, produces = "text/plain")
	public ResponseEntity<String> deleteThesis(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException,ConflictException{
		libraryServicesImpl.deleteThesis(thesisId);
		return new ResponseEntity<String>(new String("Thesis with thesis id: ["+thesisId+"] deleted successfully. "),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get course list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_COURSE_LIST, produces = "application/json")
	public ResponseEntity<List<String>> getCourseList(){
		return new ResponseEntity<List<String>>(academicsClient.getCourseList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Issue book", response = String.class, httpMethod = "PUT", produces = "text/plain")
	@PutMapping(path=RestAPI.ISSUE, produces = "text/plain")
	public ResponseEntity<String> issue(@RequestBody IssueForm issueForm) throws EventDoesNotExistException, ConflictException{
		return new ResponseEntity<String>(libraryServicesImpl.issue(issueForm),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get no of issues", response = Long.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_NO_OF_ISSUES, produces = "application/json")
	public ResponseEntity<Long> getNoOfIssues(@PathVariable("username") String username){
		return new ResponseEntity<Long>(libraryServicesImpl.getNoOfIssues(username),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get issued book info", response = IssuedInformationResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ISSUED_BOOK_INFO, produces = "application/json")
	public ResponseEntity<IssuedInformationResponse> getIssuedBookInfo(@PathVariable("bookId") String bookId) throws EventDoesNotExistException, ParseException{
		return new ResponseEntity<IssuedInformationResponse>(libraryServicesImpl.getIssuedBookInfo(bookId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get issued thesis info", response = IssuedInformationResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ISSUED_THESIS_INFO, produces = "application/json")
	public ResponseEntity<IssuedInformationResponse> getIssuedThesisInfo(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException, ParseException{
		return new ResponseEntity<IssuedInformationResponse>(libraryServicesImpl.getIssuedThesisInfo(thesisId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Return book", response = String.class, httpMethod = "PUT", produces = "text/plain")
	@PutMapping(path=RestAPI.RETURN_BOOK, produces = "text/plain")
	public ResponseEntity<String> returnBook(@PathVariable("bookId") String bookId) throws ParseException{
		return new ResponseEntity<String>(libraryServicesImpl.returnBook(bookId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Return thesis", response = String.class, httpMethod = "PUT", produces = "text/plain")
	@PutMapping(path=RestAPI.RETURN_THESIS, produces = "text/plain")
	public ResponseEntity<String> returnThesis(@PathVariable("thesisId") long thesisId) throws ParseException{
		return new ResponseEntity<String>(libraryServicesImpl.returnThesis(thesisId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get previous issues by username", response = LibraryIssueHistory.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_PREVIOUS_ISSUES_BY_USERNAME, produces = "application/json")
	public ResponseEntity<List<LibraryIssueHistory>> getPreviousIssuesByUsername(@PathVariable("username") String username) throws EventDoesNotExistException{
		return new ResponseEntity<List<LibraryIssueHistory>>(libraryServicesImpl.getPreviousIssuesByUsername(username),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get previous issues by book id", response = LibraryIssueHistory.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_PREVIOUS_ISSUES_BY_BOOKID, produces = "application/json")
	public ResponseEntity<List<LibraryIssueHistory>> getPreviousIssuesByBookId(@PathVariable("bookId") String bookId) throws EventDoesNotExistException{
		return new ResponseEntity<List<LibraryIssueHistory>>(libraryServicesImpl.getPreviousIssuesByBookId(bookId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get previous issues by thesis id", response = LibraryIssueHistory.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_PREVIOUS_ISSUES_BY_THESISID, produces = "application/json")
	public ResponseEntity<List<LibraryIssueHistory>> getPreviousIssuesByThesisId(@PathVariable("thesisId") long thesisId) throws EventDoesNotExistException{
		return new ResponseEntity<List<LibraryIssueHistory>>(libraryServicesImpl.getPreviousIssuesByThesisId(thesisId),HttpStatus.OK);
	}
	
}





