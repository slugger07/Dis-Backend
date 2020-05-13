package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.ProfilePicture;

@Repository
public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {

}
