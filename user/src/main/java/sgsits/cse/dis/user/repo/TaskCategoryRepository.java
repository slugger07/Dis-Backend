package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.TaskCategory;
/**
 * <h1>TaskCategoryRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
@Repository("taskCategoryRepository")
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, String>{

//	@Query(value = "SELECT *  FROM task_category", nativeQuery = true)
//	List<Task> getDistinctName();

}
