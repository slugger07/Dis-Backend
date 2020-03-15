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
	
	public static final String GET_TOTAL_CLEANLINESS_COMPLAINTS = "/getTotalClenalinessComplaints";
	public static final String GET_TOTAL_LE_COMPLAINTS = "/getTotalLEComplaints";
	public static final String GET_TOTAL_OTHER_COMPLAINTS = "/getTotalOtherComplaints";
	public static final String GET_TOTAL_FACULTY_COMPLAINTS = "/getTotalFacultyComplaints";
	public static final String GET_TOTAL_STUDENT_COMPLAINTS = "/getTotalStudentComplaints";
	public static final String GET_TOTAL_CWN_COMPLAINTS = "/getTotalCWNComplaints";
	public static final String GET_TOTAL_ECCW_COMPLAINTS = "/getTotalECCWComplaints";
	public static final String GET_TOTAL_EMRS_COMPLAINTS = "/getTotalEMRSComplaints";
	public static final String GET_TOTAL_TELEPHONE_COMPLAINTS = "/getTotalTelephoneComplaints";
	
	public static final String GET_REMAINING_COMPLAINTS_COUNT = "/getRemainingComplaintsCount";
	public static final String GET_RESOLVED_COMPLAINTS_COUNT = "/getResolvedComplaintsCount";
	public static final String GET_TOTAL_COMPLAINTS_COUNT = "/getTotalComplaintsCount";
	public static final String GET_MY_COMPLAINTS_COUNT = "/getMyComplaintsCount";
	
	public static final String ADD_CLEANLINESS_COMPLAINTS = "/addCleanlinessComplaint";
	public static final String ADD_LE_COMPLAINTS = "/addLEComplaint";
	public static final String ADD_OTHER_COMPLAINTS = "/addOtherComplaint";
	public static final String ADD_FACULTY_COMPLAINTS = "/addFacultyComplaint";
	public static final String ADD_STUDENT_COMPLAINTS = "/addStudentComplaint";
	public static final String ADD_CWN_COMPLAINTS = "/addCWNComplaint";
	public static final String ADD_ECCW_COMPLAINTS = "/addECCWComplaint";
	public static final String ADD_EMRS_COMPLAINTS = "/addEMRSComplaint";
	public static final String ADD_TELEPHONE_COMPLAINTS = "/addTelephoneComplaint";
	
	public static final String EDIT_COMPLAINTS = "/editComplaint";
	
	public static final String ADD_COMPLAINT_PERMISSION = "/addComplaintPermission";
		
}
