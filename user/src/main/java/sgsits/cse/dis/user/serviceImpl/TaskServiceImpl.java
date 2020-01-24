package sgsits.cse.dis.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.Task;
import sgsits.cse.dis.user.model.TaskCategory;
import sgsits.cse.dis.user.model.UserTasks;
import sgsits.cse.dis.user.repo.TaskCategoryRepository;
import sgsits.cse.dis.user.repo.TaskRepository;
import sgsits.cse.dis.user.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskCategoryRepository taskCategoryRepository;
	
	@Override
	public boolean assignTask(UserTasks userTask) {
		return false;
	}

	@Override
	public List<CategorySpecificTaskResponse> getTasksFromCategoryId(String categoryId) {
		List<Task> temp = taskRepository.findbyCategoryId(categoryId);
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
