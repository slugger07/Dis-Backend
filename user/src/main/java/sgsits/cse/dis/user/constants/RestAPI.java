package sgsits.cse.dis.user.constants;

public class RestAPI {

	//Task services
	public static final String GET_TASKS_FROM_CATEGORY_ID = "/getTasksFromCategoryId/{categoryId}";
	public static final String GET_TASKS_CATEGORY_LIST = "/getTaskCategoryList";
	public static final String GET_ACTIVE_STAFF_LIST = "/getActiveStaffList";
	public static final String ASSIGN_TASK = "/assignTask";
	public static final String SEARCH_TASK_BY_USER_ID = "/searchTaskByUserId/{userId}";
	public static final String SEARCH_TASK_BY_TASK_ID = "/searchTaskByTaskId/{taskId}";
	public static final String DELETE_TASK ="/deleteTask/{id}";
	
	//Staff profile data
	public static final String GET_FACULTY_DATA ="/getFacultyData";
	public static final String GET_STAFF_DATA ="/getStaffData";
	public static final String ADD_NEW_MEMBER ="/addNewMember";
	public static final String GET_STAFF_WITH_NAME = "/getStaffWithName/{name}";
	public static final String GET_ASSIGN_TASKS_INFO = "/getAssignTasksInfo";
	public static final String UPDATE_TASK_STATUS = "/updateTaskStatus/{status}/{id}";
	public static final String GET_MY_USER_ID = "/getMyUserID";
	
	//Guide Allotment data
	public static final String GET_ALL_BATCHES = "/getAllBatches/{session}/{ugOrPg}";
	public static final String CREATE_BATCH = "/createBatch";
	public static final String UPDATE_BATCH = "/updateBatch";
	public static final String GET_REMAINING_STUDENTS = "/getRemainingStudents/{session}/{ugOrPg}";
	public static final String GET_STUDENTS_BATCH = "/getStudentsBatch/{studentId}/{ugOrPg}";
	public static final String GET_GUIDES_BATCH = "/getGuidesBatch/{guideId}/{ugOrPg}";
}
