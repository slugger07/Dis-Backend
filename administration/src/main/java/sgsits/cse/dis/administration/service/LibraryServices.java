package sgsits.cse.dis.administration.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.LibraryBookCategoryCount;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.model.LibraryIssueHistory;
import sgsits.cse.dis.administration.model.LibrarySettings;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.request.IssueForm;
import sgsits.cse.dis.administration.response.IssuedInformationResponse;


public interface LibraryServices {
	//setting service
	List<LibrarySettings> getSetting();
	void updateSettings(LibrarySettings librarySettings) throws EventDoesNotExistException;
	
	//General
	List<LibraryIssueHistory> getPreviousIssuesByUsername(String username) throws EventDoesNotExistException;
	List<LibraryIssueHistory> getPreviousIssuesByBookId(String bookId) throws EventDoesNotExistException;
	List<LibraryIssueHistory> getPreviousIssuesByThesisId(Long thesisId) throws EventDoesNotExistException;
	
	//book services
	String addBook(AddBookForm addBookForm) throws ConflictException;
	List<LibraryBookRecords> getAllBooks();
	List<LibraryBookRecords> getBookByTitle(String title) throws EventDoesNotExistException;
	List<LibraryBookRecords> getBookByBookId(String bookId) throws EventDoesNotExistException;
	List<LibraryBookRecords> getBookByAuthorName(String authorName) throws EventDoesNotExistException;
	void updateBook(AddBookForm addBookForm, String bookId)throws EventDoesNotExistException,ConflictException;
	void deleteBook(String bookId) throws EventDoesNotExistException,ConflictException;
    List<String> getSubjectCatergoryAcronymList();
    void addNewSubjectCategory(LibraryBookCategoryCount libraryBookCategoryCount)  throws ConflictException;
	void deleteSubjectCategory(String subjectCategory) throws EventDoesNotExistException;
	
	
	//thesis services.
	Long addThesis(AddThesisForm addThesisForm) throws ConflictException;
	List<LibraryThesisRecords> getAllThesis();
	List<LibraryThesisRecords> getThesisByTitle(String title) throws EventDoesNotExistException;
	List<LibraryThesisRecords> getThesisBySubmittedBy(String submittedBy) throws EventDoesNotExistException;
	List<LibraryThesisRecords> getThesisByGuidedBy(String guidedBy) throws EventDoesNotExistException;
	List<LibraryThesisRecords> getThesisByThesisId(long thesisId) throws EventDoesNotExistException;
	List<LibraryThesisRecords> getThesisByCourse(String course) throws EventDoesNotExistException;
	void updateThesis(AddThesisForm addThesisForm, long thesisId)throws EventDoesNotExistException,ConflictException;
	void deleteThesis(long thesisId) throws EventDoesNotExistException,ConflictException;
	
	//Issue/Return service
	String issue(IssueForm issueForm) throws EventDoesNotExistException,ConflictException;
	Long getNoOfIssues(String username);
	String returnBook(String bookId) throws ParseException;
	IssuedInformationResponse getIssuedBookInfo(String bookId) throws EventDoesNotExistException, ParseException;
	String returnThesis(long thesisId) throws ParseException;
	IssuedInformationResponse getIssuedThesisInfo(long thesisId) throws EventDoesNotExistException, ParseException;

	//
}
