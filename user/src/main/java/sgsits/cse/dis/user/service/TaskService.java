package sgsits.cse.dis.user.service;

import java.util.List;
import java.util.Optional;

import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.UserTasks;

public interface TaskService {
	boolean assignTask(UserTasks userTask);
	List<TaskCategoryResponse> getTasksFromCategoryId(String category);
	
}
