package sgsits.cse.dis.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.Task;
import sgsits.cse.dis.user.model.TaskCategory;
import sgsits.cse.dis.user.model.UserTasks;
import sgsits.cse.dis.user.repo.TaskCategoryRepository;
import sgsits.cse.dis.user.repo.TaskRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.repo.UserTaskRepository;
import sgsits.cse.dis.user.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskCategoryRepository taskCategoryRepository;
	
	@Autowired
	private UserTaskRepository userTaskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Override
	public String assignTask(AssignTaskForm assignTaskForm,String userId) throws ConflictException,ConstraintViolationException {
		UserTasks test = userTaskRepository.save(new UserTasks(userId, simpleDateFormat.format(new Date()), null, null, 
				assignTaskForm.getUserId(),
				assignTaskForm.getTaskId(), 
				assignTaskForm.getDeadline(), assignTaskForm.getDescription(), assignTaskForm.getStatus()));

		if(test.equals(null))
			throw new ConflictException("Unable to assign task.");
		return "Task assigned successfully";
	}

	@Override
	public List<CategorySpecificTaskResponse> getTasksFromCategoryId(String categoryId) throws NotFoundException{
		List<Task> temp = taskRepository.findbyCategoryId(categoryId);
		if(temp.isEmpty())
			throw new NotFoundException("No record found for categoryid ["+categoryId+"]");
		List<CategorySpecificTaskResponse> taskCategoryResponses = new ArrayList<CategorySpecificTaskResponse>();
		for(Task task : temp) {
			taskCategoryResponses.add(new CategorySpecificTaskResponse(task.getId(),task.getName()));
		}
		return taskCategoryResponses;
	}

	@Override
	public List<TaskCategoryResponse> getTaskCategoryList() {
		List<TaskCategory> temp = taskCategoryRepository.findAll();
		List<TaskCategoryResponse> taskCategoryResponses = new ArrayList<TaskCategoryResponse>();
		for(TaskCategory task : temp) {
			taskCategoryResponses.add(new TaskCategoryResponse(task.getId(),task.getCategoryName()));
		}
		return taskCategoryResponses;
	}
	

}
