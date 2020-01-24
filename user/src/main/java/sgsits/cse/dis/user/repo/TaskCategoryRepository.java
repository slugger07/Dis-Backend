package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.TaskCategory;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, String>{

}
