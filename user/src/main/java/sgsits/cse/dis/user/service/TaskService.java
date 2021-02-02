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
/**
 * <h1><b>TaskService</b> interface.</h1>
 * <p>This interface lists all the task services which can be implemented by class extending it.
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
