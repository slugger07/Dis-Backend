package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.UserOtherAchievement;

import java.util.List;

@Repository
public interface UserOtherAchievementRepository extends JpaRepository<UserOtherAchievement, Long> {

    List<UserOtherAchievement> findByUserId(final String userId);
}
