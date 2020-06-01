package sgsits.cse.dis.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javassist.NotFoundException;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.SearchTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.Task;
import sgsits.cse.dis.user.model.TaskCategory;
import sgsits.cse.dis.user.model.UserTasks;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
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
	
	@Autowired
	private StaffBasicProfileRepository staffBasicProfileRepository;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Override
	public String assignTask(AssignTaskForm assignTaskForm,String assignedByUserId) throws ConflictException,DataIntegrityViolationException {
		try{UserTasks test = userTaskRepository.save(new UserTasks(assignedByUserId, simpleDateFormat.format(new Date()), null, null, 
				assignTaskForm.getUserId(),
				assignTaskForm.getTaskId(), 
				assignTaskForm.getDeadline(), assignTaskForm.getDescription(), assignTaskForm.getStatus()));
				if(test.equals(null))
					throw new ConflictException("Unable to assign task.");
		}
		catch (Exception e) {
			throw new DataIntegrityViolationException("This user is already assigned to same task.");
		}

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

	@Override
	public List<SearchTaskResponse> searchTaskByUserId(String userId) throws NotFoundException{
		List<UserTasks> userTasks = userTaskRepository.findByUserId(userId);
		List<SearchTaskResponse> searchTaskResponses = new ArrayList<SearchTaskResponse>();
		for(UserTasks temp : userTasks)
			searchTaskResponses.add(new SearchTaskResponse(temp.getId(),temp.getUserId(), staffBasicProfileRepository.findNameByUserId(userId).getName(),
					temp.getTaskId(), taskRepository.findNameById(temp.getTaskId()).getName(), 
					temp.getDeadline(), temp.getDescription(), temp.getStatus(),temp.getCreatedDate()));
		return searchTaskResponses;
	}

	@Override
	public List<SearchTaskResponse> searchTaskByTaskId(String taskId) throws NotFoundException {
		List<UserTasks> userTasks = userTaskRepository.findByTaskId(taskId);
		List<SearchTaskResponse> searchTaskResponses = new ArrayList<SearchTaskResponse>();
		for(UserTasks temp : userTasks)
			searchTaskResponses.add(new SearchTaskResponse(temp.getId(),temp.getUserId(), staffBasicProfileRepository.findNameByUserId(temp.getUserId()).getName(),
					temp.getTaskId(), taskRepository.findNameById(taskId).getName(), 
					temp.getDeadline(), temp.getDescription(), temp.getStatus(),temp.getCreatedDate()));
		return searchTaskResponses;
	}

	@Transactional
	@Override
	public void deleteTask(String id) throws ConflictException {
		if(userTaskRepository.deleteTaskById(id)<=0)
			throw new ConflictException("Cannot Delete selected task");
		
	}
	
	@Override
	public List<SearchTaskResponse> getAssignTasksInfo() {
		List<Object[]> infos = userTaskRepository.findAssignTaskInfo();
		List<SearchTaskResponse> assignTasksInfo = new ArrayList<SearchTaskResponse>();
		for(Object[] info : infos) {
			assignTasksInfo.add(new SearchTaskResponse(String.valueOf(info[8]),String.valueOf(info[0]), String.valueOf(info[1]), String.valueOf(info[2]),
					String.valueOf(info[3]), info[4], info[5], info[6], String.valueOf(info[7])));
		}
		return assignTasksInfo;
	}

	@Transactional
	@Override
	public void updateStatus(String status, String id) {
		userTaskRepository.updateStatusById(status,id);
		
	}	
	

}
