package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserCompetitiveExam;

import java.util.List;

@Repository
public interface UserCompetitiveExamRepository extends JpaRepository<UserCompetitiveExam, Long> {
    List<UserCompetitiveExam> findByUserId(String userId);
}
