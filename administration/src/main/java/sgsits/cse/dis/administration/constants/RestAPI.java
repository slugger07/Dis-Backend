package sgsits.cse.dis.administration.constants;

public class RestAPI {
	
	
	//LIBRARY API's
	public static final String ADD_BOOK ="/addBook"; 
	public static final String GET_ALL_BOOKS ="/getAllBooks";
	public static final String GET_BOOK_BY_TITLE = "/getBookByTitle/{title}";
	public static final String GET_BOOK_BY_AUTHOR_NAME = "/getBookByAuthorName/{authorName}";
	public static final String GET_SUBJECT_CATEGORY_LIST = "/getSubjectCatergoryAcronymList";
	public static final String UPDATE_BOOK = "/updateBook/{bookId}";
	public static final String DELETE_BOOK = "/deleteBook/{bookId}"; 
	public static final String ADD_THESIS = "/addThesis"; 
	
	//My Complaints
	public static final String GET_MY_CLEANLINESS_COMPLAINTS = "/getMyCleanlinessComplaints";
	public static final String GET_MY_LE_COMPLAINTS = "/getMyLEComplaints";
	public static final String GET_MY_OTHER_COMPLAINTS = "/getMyOtherComplaints";
	public static final String GET_MY_FACULTY_COMPLAINTS = "/getMyFacultyComplaints";
	public static final String GET_MY_STUDENT_COMPLAINTS = "/getMyStudentComplaints";
	
}
