package sgsits.cse.dis.administration.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

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

/**
 * <h1><b>LibraryService</b> interface.</h1>
 * <p>This interface lists all the library services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */
public interface LibraryServices {
	//setting service
	
	/**
	 * Get library settings.
	 * @return LibrarySettings List
	 */
	List<LibrarySettings> getSetting();
	
	/**
	 * Update library settings.
	 * @param librarySettings.
	 * @return void.
	 */
	void updateSettings(LibrarySettings librarySettings) throws EventDoesNotExistException;
	
	//General
	
	/**
	 * Get previous issue history of a particular user by "username".
	 * @param username.
	 * @return LibraryIssueHistory List
	 */
	List<LibraryIssueHistory> getPreviousIssuesByUsername(String username) throws EventDoesNotExistException;
	
	/**
	 * Get previous issue history of a particular book by "bookId".
	 * @param bookId.
	 * @return LibraryIssueHistory List
	 */
	List<LibraryIssueHistory> getPreviousIssuesByBookId(String bookId) throws EventDoesNotExistException;
	
	/**
	 * Get previous issue history of a particular thesis by "thesisId".
	 * @param thesisId.
	 * @return LibraryIssueHistory List
	 */
	List<LibraryIssueHistory> getPreviousIssuesByThesisId(Long thesisId) throws EventDoesNotExistException;
	
	//book services
	/** add a new book into the system.
	 * @param AddBookForm
	 * @return message
	 */
	String addBook(AddBookForm addBookForm) throws ConflictException;
	
	/**
	 * List all book present in the system.
	 * @return LibraryBookRecords List
	 */
	List<LibraryBookRecords> getAllBooks();
	
	/**
	 * List all book by given "title" present in the system.
	 * @param title
	 * @return LibraryBookRecords List
	 */
	List<LibraryBookRecords> getBookByTitle(String title) throws EventDoesNotExistException;
	
	/**
	 * List all book by given "bookId" present in the system.
	 * @param bookId
	 * @return LibraryBookRecords List
	 */
	List<LibraryBookRecords> getBookByBookId(String bookId) throws EventDoesNotExistException;
	
	/**
	 * List all book by given "authorName" present in the system.
	 * @param authorName
	 * @return LibraryBookRecords List
	 */
	List<LibraryBookRecords> getBookByAuthorName(String authorName) throws EventDoesNotExistException;
	
	/**
	 * update book currently present in the system.
	 * @param addBookForm, bookId
	 * @return LibraryBookRecords List
	 */
	void updateBook(AddBookForm addBookForm, String bookId)throws EventDoesNotExistException,ConflictException;
	
	/**
	 * delete a book currently present in the system.
	 * @param bookId
	 * @return void
	 */
	void deleteBook(String bookId) throws EventDoesNotExistException,ConflictException;
	
	/**
	 * Get subject acronym (subjectCategory) list
	 * @return subjectAcronym List
	 */
    List<String> getSubjectCatergoryAcronymList();
   
    /**
	 * Insert a new "subjectCategory"(acronym) for inserting book and generate bookId.
	 * @param LibrarybookCategoryCount.
	 * @return void.
	 */
    void addNewSubjectCategory(LibraryBookCategoryCount libraryBookCategoryCount)  throws ConflictException;
	
	/**
	 * Delete "subjectCategory"(acronym).
	 * @param subjectCategory.
	 * @return void.
	 */
    void deleteSubjectCategory(String subjectCategory) throws EventDoesNotExistException;

	/**
	 *Get subjectName by subjectCategory(acronym).
	 * @param subjectCategory.
	 * @return LibraryBookCategoryCount List.
	 */
    List<LibraryBookCategoryCount> getSubjectNameByAcronym(String subjectCategory) throws EventDoesNotExistException;
	
	/**
	 *Get subjectCategory(acronym) by subjectName.
	 * @param subjectName.
	 * @return LibraryBookCategoryCount List.
	 */
    List<LibraryBookCategoryCount> getAcronymBySubjectName(String subjectName) throws EventDoesNotExistException;
	
	
	//thesis services.
	
	/**
	 * add new thesis in the system.
	 * @param addThesisForm
	 * @return thesisId
	 */
	Long addThesis(AddThesisForm addThesisForm) throws ConflictException;
	
	/**
	 * Get list of all thesis in the system.
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getAllThesis();
	
	/**
	 * Get list of all thesis by "title" in the system.
	 * @param title
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getThesisByTitle(String title) throws EventDoesNotExistException;
	
	/**
	 * Get list of all thesis by "submittedBy" in the system.
	 * @param submittedBy
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getThesisBySubmittedBy(String submittedBy) throws EventDoesNotExistException;
	
	/**
	 * Get list of all thesis by "guidedBy" in the system.
	 * @param guidedBy
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getThesisByGuidedBy(String guidedBy) throws EventDoesNotExistException;
	
	/**
	 * Get list of all thesis by "thesisId" in the system.
	 * @param thesisId
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getThesisByThesisId(long thesisId) throws EventDoesNotExistException;
	
	/**
	 * Get list of all thesis by "course" in the system.
	 * @param course
	 * @return LibraryThesisRecords List
	 */
	List<LibraryThesisRecords> getThesisByCourse(String course) throws EventDoesNotExistException;
	
	/**
	 * update a thesis in the system.
	 * @param addThesisForm, thesisID
	 * @return void
	 */
	void updateThesis(AddThesisForm addThesisForm, long thesisId)throws EventDoesNotExistException,ConflictException;
	
	/**
	 * delete a thesis in the system.
	 * @param thesisID
	 * @return void
	 */
	void deleteThesis(long thesisId) throws EventDoesNotExistException,ConflictException;
	
	//Issue/Return service
	
	/**
	 * Issue a book or thesis.
	 * @param issueForm
	 * @return message
	 */
	String issue(IssueForm issueForm) throws EventDoesNotExistException,ConflictException;
	
	/**
	 * Get no of issues by the "username".
	 * @param username
	 * @return noOfIssues
	 */
	Long getNoOfIssues(String username);
	
	/**
	 * Return a book.
	 * @param bookId.
	 * @return message.
	 */
	String returnBook(String bookId) throws ParseException;
	
	/**
	 * Get current issued information of a book by the bookId.
	 * @param bookId.
	 * @return IssuedInformationResponse.
	 */
	IssuedInformationResponse getIssuedBookInfo(String bookId) throws EventDoesNotExistException, ParseException;
	
	/**
	 * Return a thesis.
	 * @param thesisId.
	 * @return message.
	 */
	String returnThesis(long thesisId) throws ParseException;
	
	/**
	 * Get current issued information of a thesis by the thesisId.
	 * @param thesisId.
	 * @return IssuedInformationResponse.
	 */
	IssuedInformationResponse getIssuedThesisInfo(long thesisId) throws EventDoesNotExistException, ParseException;

	//
}
