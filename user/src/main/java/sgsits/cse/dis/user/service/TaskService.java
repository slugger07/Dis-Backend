package sgsits.cse.dis.user.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import javassist.NotFoundException;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.SearchTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;

public interface TaskService {
	String assignTask(AssignTaskForm assignTaskForm,String assignedByUserId) throws ConflictException,DataIntegrityViolationException;
	List<CategorySpecificTaskResponse> getTasksFromCategoryId(String category) throws NotFoundException;
	List<TaskCategoryResponse> getTaskCategoryList();
	List<SearchTaskResponse> searchTaskByUserId(String userId) throws NotFoundException;
	List<SearchTaskResponse> searchTaskByTaskId(String taskId) throws NotFoundException;
	void deleteTask(String id) throws ConflictException;
	//List<Object[]> getAssignTasksInfo();
	List<SearchTaskResponse> getAssignTasksInfo();
	void updateStatus(String status,String id);
	
}
