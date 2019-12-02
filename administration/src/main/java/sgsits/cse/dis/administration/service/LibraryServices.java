package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;

@Component
public interface LibraryServices {
	String addBook(AddBookForm addBookForm) throws ConflictException;
	List<LibraryBookRecordsResponse> getAllBooks();
	List<LibraryBookRecordsResponse> getBookByTitle(String title) throws EventDoesNotExistException;
	List<LibraryBookRecordsResponse> getBookByAuthorName(String authorName) throws EventDoesNotExistException;
 }
