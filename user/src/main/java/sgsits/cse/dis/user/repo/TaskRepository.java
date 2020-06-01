package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String>{
	
	Task findIdByName(String name);
	Task findNameById(String id);

//	@Query(value = "SELECT id,name FROM task WHERE category = ?1", nativeQuery = true)
//	List<TaskCategoryResponse> findIdAndNameByCategoryId(String categoryId);
//	
//	@Query(value = "SELECT DISTINCT category FROM task", nativeQuery = true)
//	Optional<Task> getDistinctTask();
	@Query(value = "SELECT * FROM task WHERE category = ?1", nativeQuery = true)
	List<Task> findbyCategoryId(String categoryId);
}
