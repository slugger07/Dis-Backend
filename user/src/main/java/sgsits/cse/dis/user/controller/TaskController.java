package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.AssignTaskForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.message.response.CategorySpecificTaskResponse;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.message.response.SearchTaskResponse;
import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.service.TaskService;
import sgsits.cse.dis.user.serviceImpl.TaskServiceImpl;
import sgsits.cse.dis.user.serviceImpl.UserServicesImpl;

@CrossOrigin(origins = "*")
@Api(value = "Task controller")
@RestController
@RequestMapping(path = "/task")
public class TaskController {
	
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private TaskService taskServiceImpl;
	
	@Autowired
	private UserServicesImpl userServicesImpl;
	
	@ApiOperation(value="Get Tasks list from category id", response = CategorySpecificTaskResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_TASKS_FROM_CATEGORY_ID, produces = "application/json")
	public ResponseEntity<List<CategorySpecificTaskResponse>> getTasksFromCategoryId(@PathVariable("categoryId") String categoryId) throws NotFoundException{
		return new ResponseEntity<List<CategorySpecificTaskResponse>>(taskServiceImpl.getTasksFromCategoryId(categoryId),HttpStatus.OK);
	}
	
	@ApiOperation(value="get task category list", response = TaskCategoryResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_TASKS_CATEGORY_LIST, produces = "application/json")
	public ResponseEntity<List<TaskCategoryResponse>> getTasksCategoryList(){
		return new ResponseEntity<List<TaskCategoryResponse>>(taskServiceImpl.getTaskCategoryList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="get active staff list", response = ActiveStaffListResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ACTIVE_STAFF_LIST, produces = "application/json")
	public ResponseEntity<List<ActiveStaffListResponse>> activeStaffListResponse() throws NotFoundException{
		return new ResponseEntity<List<ActiveStaffListResponse>>(userServicesImpl.getActiveStaffList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="get active staff list", response = ResponseMessage.class, httpMethod = "POST", produces = "text/plain")
	@PostMapping(path=RestAPI.ASSIGN_TASK, produces = "application/json")
	public ResponseEntity<ResponseMessage> assignTask(@RequestBody AssignTaskForm assignTaskForm,HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(taskServiceImpl.assignTask(assignTaskForm,
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))),
				HttpStatus.OK);
	}
	
	@ApiOperation(value="search tasks by user id", response = SearchTaskResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.SEARCH_TASK_BY_USER_ID, produces = "application/json")
	public ResponseEntity<List<SearchTaskResponse>> searchTaskByUserId(@PathVariable("userId") String userId) throws NotFoundException{
		return new ResponseEntity<List<SearchTaskResponse>>(taskServiceImpl.searchTaskByUserId(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value="search tasks by task id", response = SearchTaskResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.SEARCH_TASK_BY_TASK_ID, produces = "application/json")
	public ResponseEntity<List<SearchTaskResponse>> searchTaskByTaskId(@PathVariable("taskId") String taskId) throws NotFoundException{
		return new ResponseEntity<List<SearchTaskResponse>>(taskServiceImpl.searchTaskByTaskId(taskId),HttpStatus.OK);
	}
	
	@ApiOperation(value="delete a task", response = String.class, httpMethod = "DELETE", produces = "text/plain")
	@DeleteMapping(path=RestAPI.DELETE_TASK, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteTask(@PathVariable("id") String id ) throws ConflictException{
		taskServiceImpl.deleteTask(id);	
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Tasks deleted successfully. "),HttpStatus.OK);
	}
	
//	@ApiOperation(value="Get all assign task info", response = CategorySpecificTaskResponse.class, httpMethod = "GET", produces = "application/json")
//	@GetMapping(path=RestAPI.GET_ASSIGN_TASKS_INFO, produces = "application/json")
//	public ResponseEntity<List<Object[]>> getAssignTasksInfo() throws NotFoundException{
//		return new ResponseEntity<List<Object[]>>(taskServiceImpl.getAssignTasksInfo(),HttpStatus.OK);
//	}
	
	@ApiOperation(value="Get all assign task info", response = SearchTaskResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ASSIGN_TASKS_INFO, produces = "application/json")
	public ResponseEntity<List<SearchTaskResponse>> getAssignTasksInfo() throws NotFoundException{
		return new ResponseEntity<List<SearchTaskResponse>>(taskServiceImpl.getAssignTasksInfo(),HttpStatus.OK);
	}
	
}
