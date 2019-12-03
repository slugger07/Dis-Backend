package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.administration.model.LibraryBookCount;

public interface LibraryBookCountRepository extends JpaRepository<LibraryBookCount, Long> {

	List<LibraryBookCount> findBySubjectCategory(String subjectCategory);

	@Transactional
	@Modifying
	@Query(value = "UPDATE library_book_count SET count = count + 1 WHERE subject_category = ?1", nativeQuery = true)
	void updateCount(String subjectCategory);

}
