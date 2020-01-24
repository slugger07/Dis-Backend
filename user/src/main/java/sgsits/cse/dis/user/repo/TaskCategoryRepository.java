package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.TaskCategory;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, String>{

//	@Query(value = "SELECT *  FROM task_category", nativeQuery = true)
//	List<Task> getDistinctName();

}
