package sgsits.cse.dis.academics.constants;

public class RestAPI {

	public static final String GET_SEM_TIME_TABLE_SETTINGS = "/getSemTimeTableSettings";
	public static final String SAVE_SEM_TIME_TABLE_SETTINGS = "/saveSemTimeTableSettings";
	public static final String GET_FACULTY_NAME_LIST = "/getFacultyNameList";
	public static final String GET_COURSE_NAME_BY_COURSE_ID = "getCourseNameByCourseId/{courseId}";
	public static final String GET_COURSE_ID_BY_COURSE_NAME = "getCourseIdByCourseName/{courseName}";
	public static final String GET_COURSE_LIST = "/getCourseList";
	public static final String GET_SUBJECT_CODES_LIST_BY_YEAR_AND_SEMESTER = "getSubjectCodesListByYearAndSemster/{year}/{sem}";
	public static final String GET_INFRASTRUCTURE_BY_TYPE = "/getInfrastructureByType/{type}";

}