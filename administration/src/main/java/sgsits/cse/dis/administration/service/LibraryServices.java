package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.response.LibraryBookRecordsResponse;

@Component
public interface LibraryServices {
	boolean addBook(AddBookForm addBookForm);
	List<LibraryBookRecordsResponse> getAllBooks();
	List<LibraryBookRecordsResponse> getBookByTitle(String title);
	List<LibraryBookRecordsResponse> getBookByAuthorName(String authorName);
 }
