package sgsits.cse.dis.user.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import javassist.NotFoundException;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;

public interface TaskService {
	String assignTask(AssignTaskForm assignTaskForm,String userId) throws ConflictException,ConstraintViolationException;
	List<CategorySpecificTaskResponse> getTasksFromCategoryId(String category) throws NotFoundException;
	List<TaskCategoryResponse> getTaskCategoryList();
}
