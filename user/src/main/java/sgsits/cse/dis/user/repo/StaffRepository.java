package sgsits.cse.dis.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.StaffProfile;

@Repository("staffRepository")
public interface StaffRepository extends JpaRepository<StaffProfile, Long>{
	Optional<StaffProfile> findByEmail(String email);
	Optional<StaffProfile> findByEmployeeId(String employeeId);
	Optional<StaffProfile> findByUserId(Long id);
	
	//@Query(value="SELECT s.name, s.email from staff_basic_profile s where class = 'I' or class = 'II' order by current_designation", nativeQuery=true)
	List<StaffProfile> findByClasssOrClasssOrderByCurrentDesignation(String classs1, String classs2);

}
