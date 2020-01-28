package sgsits.cse.dis.administration.constants;

public class RestAPI {
	
	
	//LIBRARY API's
	
	//General
	public static final String GET_COURSE_LIST = "/getCourseList";
	public static final String ISSUE = "/issue";
	public static final String GET_NO_OF_ISSUES = "/getNoOfIssues/{username}";
	public static final String GET_SUBJECT_CATEGORY_LIST = "/getSubjectCatergoryAcronymList";
	
	//Settings
	public static final String GET_LIBRARY_SETTINGS = "/getLibrarySettings";
	public static final String UPDATE_LIBRARY_SETTINGS ="/updateLibrarySettings";
	
	//Books
	public static final String ADD_BOOK ="/addBook"; 
	public static final String GET_ALL_BOOKS ="/getAllBooks";
	public static final String GET_BOOK_BY_TITLE = "/getBookByTitle/{title}";
	public static final String GET_BOOK_BY_BOOK_ID = "/getBookByBookId/{bookId}";
	public static final String GET_BOOK_BY_AUTHOR_NAME = "/getBookByAuthorName/{authorName}";
	public static final String UPDATE_BOOK = "/updateBook/{bookId}";
	public static final String DELETE_BOOK = "/deleteBook/{bookId}";
	public static final String RETURN_BOOK = "/returnBook/{bookId}";
	public static final String GET_ISSUED_BOOK_INFO ="/getIssuedBookInfo/{bookId}";
	public static final String ADD_BOOK_CATEGORY = "/addNewBookCategory";
	public static final String DELETE_CATEGORY = "/deleteBookCategory/{SubjectCategory}";
	public static final String GET_ACRONYM_BY_SUBJECT_NAME = "/getAcronymBySubjectName/{subjectName}";
	public static final String GET_SUBJECT_NAME_BY_ACRONYM = "/getSubjectNameByAcronym/{acronym}";
	
	//Thesis
	public static final String ADD_THESIS = "/addThesis"; 
	public static final String GET_ALL_THESIS ="/getAllThesis";
	public static final String GET_THESIS_BY_TITLE = "/getThesisByTitle/{title}";
	public static final String GET_THESIS_BY_SUBMITTED_BY = "/getThesisBySubmittedBy/{submittedBy}";
	public static final String GET_THESIS_BY_GUIDED_BY = "/getThesisByGuidedBy/{guidedBy}";
	public static final String GET_THESIS_BY_THESIS_ID = "/getThesisByThesisId/{thesisId}";
	public static final String GET_THESIS_BY_COURSE = "/getThesisByCourse/{course}";
	public static final String UPDATE_THESIS = "/updateThesis/{thesisId}";
	public static final String DELETE_THESIS = "/deleteThesis/{thesisId}";
	public static final String RETURN_THESIS = "/returnThesis/{thesisId}";
	public static final String GET_ISSUED_THESIS_INFO ="/getIssuedThesisInfo/{thesisId}";
	
	//Previous Issues
	public static final String GET_PREVIOUS_ISSUES_BY_USERNAME ="/getPreviousIssuesByUsername/{username}";
	public static final String GET_PREVIOUS_ISSUES_BY_BOOKID ="/getPreviousIssuesByBookId/{bookId}";
	public static final String GET_PREVIOUS_ISSUES_BY_THESISID ="/getPreviousIssuesByThesisId/{thesisId}";

	
	

}
