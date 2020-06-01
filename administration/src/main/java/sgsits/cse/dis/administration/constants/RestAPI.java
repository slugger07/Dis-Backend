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

	
	public static final String GET_TOTAL_CLEANLINESS_COMPLAINTS = "/getTotalClenalinessComplaints";
	public static final String GET_TOTAL_LE_COMPLAINTS = "/getTotalLEComplaints";
	public static final String GET_TOTAL_OTHER_COMPLAINTS = "/getTotalOtherComplaints";
	public static final String GET_TOTAL_FACULTY_COMPLAINTS = "/getTotalFacultyComplaints";
	public static final String GET_TOTAL_STUDENT_COMPLAINTS = "/getTotalStudentComplaints";
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
		
	//Remaining Complaints
	public static final String GET_REMAINING_CLEANLINESS_COMPLAINTS = "/getRemainingCleanlinessComplaints";
	public static final String GET_REMAINING_LE_COMPLAINTS = "/getRemainingLEComplaints";
	public static final String GET_REMAINING_OTHER_COMPLAINTS = "/getRemainingOtherComplaints";
	public static final String GET_REMAINING_FACULTY_COMPLAINTS = "/getRemainingFacultyComplaints";
	public static final String GET_REMAINING_STUDENT_COMPLAINTS = "/getRemainingStudentComplaints";
	public static final String GET_REMAINING_CWN_COMPLAINTS = "/getRemainingCWNComplaints";
	public static final String GET_REMAINING_ECCW_COMPLAINTS = "/getRemainingECCWComplaints";
	public static final String GET_REMAINING_EMRS_COMPLAINTS = "/getRemainingEMRSComplaints";
	public static final String GET_REMAINING_TELEPHONE_COMPLAINTS = "/getRemainingTelephoneComplaints";
	
	//Faculty Resources
	public static final String ADD_FACULTY_RESOURCE_REQUEST = "/addFacultyResourceRequest";
	public static final String GET_FACULTY_RESOURCE_REQUEST = "/getFacultyResourceRequest/{id}";
	public static final String EDIT_FACULTY_RESOURCE_REQUEST = "/editFacultyResourceRequest/{id}";
	public static final String GET_ALL_FACULTY_REQUESTS_FOR_ID = "/getAllFacultyRequestsForId";
	public static final String GET_ALL_FACULTY_REQUESTS_RESOLVED = "/getAllResolvedFacultyRequests";
	public static final String GET_ALL_FACULTY_REQUESTS_UNRESOLVED = "/getAllUnresolvedFacultyRequests";
	public static final String SET_FACULTY_REQUEST_RESOLVED = "/setFacultyRequestResolved/{id}";
}
