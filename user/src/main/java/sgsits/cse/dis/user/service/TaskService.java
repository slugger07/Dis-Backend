package sgsits.cse.dis.user.service;

import java.util.List;

import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.UserTasks;

public interface TaskService {
	boolean assignTask(UserTasks userTask);
	List<CategorySpecificTaskResponse> getTasksFromCategoryId(String category);
	List<TaskCategoryResponse> getTaskCategoryList();
}
