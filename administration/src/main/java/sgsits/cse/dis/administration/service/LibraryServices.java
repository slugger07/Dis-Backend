package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;

@Component
public interface LibraryServices {
	//book services
	String addBook(AddBookForm addBookForm) throws ConflictException;
	List<LibraryBookRecords> getAllBooks();
	List<LibraryBookRecords> getBookByTitle(String title) throws EventDoesNotExistException;
	List<LibraryBookRecords> getBookByAuthorName(String authorName) throws EventDoesNotExistException;
	void updateBook(AddBookForm addBookForm, String bookId)throws ConflictException;
	void deleteBook(String bookId) throws EventDoesNotExistException;
	
	//thesis services.
	Long addThesis(AddThesisForm addThesisForm) throws ConflictException;
	
 }
