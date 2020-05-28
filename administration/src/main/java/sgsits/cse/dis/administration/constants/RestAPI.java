package sgsits.cse.dis.administration.constants;

public class RestAPI {
	
	//Library APIs
	public static final String ADD_BOOK ="/addBook"; 
	public static final String GET_ALL_BOOKS ="/getAllBooks";
	public static final String GET_BOOK_BY_TITLE = "/getBookByTitle/{title}";
	public static final String GET_BOOK_BY_AUTHOR_NAME = "/getBookByAuthorName/{authorName}";
	public static final String GET_SUBJECT_CATEGORY_LIST = "/getSubjectCatergoryAcronymList";
	public static final String UPDATE_BOOK = "/updateBook/{bookId}";
	public static final String DELETE_BOOK = "/deleteBook/{bookId}"; 
	public static final String ADD_THESIS = "/addThesis"; 
	
	//Resolved Complaints
	public static final String GET_RESOLVED_CLEANLINESS_COMPLAINTS = "/getResolvedCleanlinessComplaints";
	public static final String GET_RESOLVED_LE_COMPLAINTS = "/getResolvedLEComplaints";
	public static final String GET_RESOLVED_OTHER_COMPLAINTS = "/getResolvedOtherComplaints";
	public static final String GET_RESOLVED_FACULTY_COMPLAINTS = "/getResolvedFacultyComplaints";
	public static final String GET_RESOLVED_STUDENT_COMPLAINTS = "/getResolvedStudentComplaints";
	public static final String GET_RESOLVED_CWN_COMPLAINTS = "/getResolvedCWNComplaints";
	public static final String GET_RESOLVED_ECCW_COMPLAINTS = "/getResolvedECCWComplaints";
	public static final String GET_RESOLVED_EMRS_COMPLAINTS = "/getResolvedEMRSComplaints";
	public static final String GET_RESOLVED_TELEPHONE_COMPLAINTS = "/getResolvedTelephoneComplaints";
	
	//My Complaints
	public static final String GET_MY_CLEANLINESS_COMPLAINTS = "/getMyCleanlinessComplaints";
	public static final String GET_MY_LE_COMPLAINTS = "/getMyLEComplaints";
	public static final String GET_MY_OTHER_COMPLAINTS = "/getMyOtherComplaints";
	public static final String GET_MY_FACULTY_COMPLAINTS = "/getMyFacultyComplaints";
	public static final String GET_MY_STUDENT_COMPLAINTS = "/getMyStudentComplaints";
	
	//Total Complaints
	public static final String GET_TOTAL_CWN_COMPLAINTS = "/getTotalCWNComplaints";
	public static final String GET_TOTAL_ECCW_COMPLAINTS = "/getTotalECCWComplaints";
	public static final String GET_TOTAL_EMRS_COMPLAINTS = "/getTotalEMRSComplaints";
	public static final String GET_TOTAL_TELEPHONE_COMPLAINTS = "/getTotalTelephoneComplaints";
	
}
