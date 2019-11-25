package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.administration.model.LibraryBookRecords;

public interface LibraryBookRecordsRepository extends JpaRepository<LibraryBookRecords, Long> {
	
	List<LibraryBookRecords> findByTitleContainingIgnoreCase(String title);

	List<LibraryBookRecords> findByAuthorNameContainingIgnoreCase(String authorName);

	List<LibraryBookRecords> findBySubjectCategory(String subjectCategory);

}
