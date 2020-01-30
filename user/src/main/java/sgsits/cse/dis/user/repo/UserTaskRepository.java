package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import sgsits.cse.dis.user.model.UserTasks;

public interface UserTaskRepository extends JpaRepository<UserTasks , String> {

	List<UserTasks> findByUserId(String userId);

	List<UserTasks> findByTaskId(String taskId);

	@Modifying
	long deleteByUserIdAndTaskId(String userId, String taskId);

}
