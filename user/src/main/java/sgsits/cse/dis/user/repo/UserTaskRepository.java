package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask , String> {

}
