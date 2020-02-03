package sgsits.cse.dis.user.constants;

public class RestAPI {

	//Task services
	public static final String GET_TASKS_FROM_CATEGORY_ID = "/getTasksFromCategoryId/{categoryId}";
	public static final String GET_TASKS_CATEGORY_LIST = "/getTaskCategoryList";
	public static final String GET_ACTIVE_STAFF_LIST = "/getActiveStaffList";
	public static final String ASSIGN_TASK = "/assignTask";
	public static final String SEARCH_TASK_BY_USER_ID = "/searchTaskByUserId/{userId}";
	public static final String SEARCH_TASK_BY_TASK_ID = "/searchTaskByTaskId/{taskId}";
	public static final String DELETE_TASK ="/deleteTask/{userId}/{taskId}";
	
	//Staff profile data
	public static final String GET_FACULTY_DATA ="/getFacultyData";
	public static final String GET_STAFF_DATA ="/getStaffData";
	public static final String ADD_NEW_MEMBER ="/addNewMember";
	public static final String GET_STAFF_WITH_NAME = "/getStaffWithName/{name}";
}
