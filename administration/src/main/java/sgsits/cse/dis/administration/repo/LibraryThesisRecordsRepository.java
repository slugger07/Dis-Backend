package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.LibraryThesisRecords;

@Repository
public interface LibraryThesisRecordsRepository extends JpaRepository<LibraryThesisRecords, Long> {

	List<LibraryThesisRecords> findByTitleContainingIgnoreCase(String title);

	List<LibraryThesisRecords> findBySubmittedByContainingIgnoreCase(String submittedBy);

	List<LibraryThesisRecords> findByGuidedByContainingIgnoreCase(String guidedBy);

	List<LibraryThesisRecords> findByThesisId(long thesisId);

	List<LibraryThesisRecords> findByCourseContainingIgnoreCase(String course);

	boolean existsByThesisId(long thesisId);
	
	@Modifying
	long deleteByThesisId(long thesisId);

	@Query(value = "UPDATE library_thesis_records SET status =?1 WHERE thesis_id = ?2", nativeQuery = true)
	@Modifying
	void updateStatus(String string, long thesisId);
}
