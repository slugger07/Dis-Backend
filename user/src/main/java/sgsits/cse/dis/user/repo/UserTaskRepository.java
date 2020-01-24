package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.UserTasks;

public interface UserTaskRepository extends JpaRepository<UserTasks , String> {

}
