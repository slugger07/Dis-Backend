package sgsits.cse.dis.administration.service;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.request.AddBookForm;

@Component
public interface LibraryServices {
	boolean addBook(AddBookForm addBookForm);
}
