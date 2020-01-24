package sgsits.cse.dis.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.Task;
import sgsits.cse.dis.user.model.UserTasks;
import sgsits.cse.dis.user.repo.TaskRepository;
import sgsits.cse.dis.user.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public boolean assignTask(UserTasks userTask) {
		return false;
	}

	@Override
	public List<TaskCategoryResponse> getTasksFromCategoryId(String categoryId) {
		List<Task> temp = taskRepository.findbyCategoryId(categoryId);
		List<TaskCategoryResponse> taskCategoryResponses = new ArrayList<TaskCategoryResponse>();
		for(Task task : temp) {
			taskCategoryResponses.add(new TaskCategoryResponse(task.getId(),task.getName()));
		}
		return taskCategoryResponses;
	}
	

}
