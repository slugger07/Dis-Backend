package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.user.model.UserTasks;

public interface UserTaskRepository extends JpaRepository<UserTasks , String> {

	List<UserTasks> findByUserId(String userId);

	List<UserTasks> findByTaskId(String taskId);

	@Modifying
	long deleteByUserIdAndTaskId(String userId, String taskId);

//	@Query(value="SELECT user_tasks.user_id,staff_basic_profile.name as username, "
//			+ "user_tasks.task_id, task.name as taskname ,"
//			+ "user_tasks.deadline,user_tasks.description ,"
//			+ "user_tasks.status,user_tasks.created_date "
//			+ "FROM staff_basic_profile,task,user_tasks "
//			+ "WHERE user_tasks.task_id = task.id AND  user_tasks.user_id=staff_basic_profile.user_id",nativeQuery = true ) 
	@Query(value="SELECT user_tasks.user_id,staff_basic_profile.name as username, user_tasks.task_id, task.name as taskname ,user_tasks.deadline,user_tasks.description ,user_tasks.status,user_tasks.created_date FROM staff_basic_profile,task,user_tasks WHERE user_tasks.task_id = task.id AND  user_tasks.user_id=staff_basic_profile.user_id;",nativeQuery = true)
	List<Object[]> findAssignTaskInfo();

}