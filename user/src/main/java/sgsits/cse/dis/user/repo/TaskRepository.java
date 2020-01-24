package sgsits.cse.dis.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.message.response.TaskCategoryResponse;
import sgsits.cse.dis.user.model.Task;

@Component
public interface TaskRepository extends JpaRepository<Task, String>{

//	@Query(value = "SELECT id,name FROM task WHERE category = ?1", nativeQuery = true)
//	List<TaskCategoryResponse> findIdAndNameByCategoryId(String categoryId);
//	
//	@Query(value = "SELECT DISTINCT category FROM task", nativeQuery = true)
//	Optional<Task> getDistinctTask();
	@Query(value = "SELECT * FROM task WHERE category = ?1", nativeQuery = true)
	List<Task> findbyCategoryId(String categoryId);
}
