package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.LibraryBookRecords;

@Repository
public interface LibraryBookRecordsRepository extends JpaRepository<LibraryBookRecords, Long> {
	
	List<LibraryBookRecords> findByTitleContainingIgnoreCase(String title);

	List<LibraryBookRecords> findByAuthorNameContainingIgnoreCase(String authorName);

	List<LibraryBookRecords> findBySubjectCategory(String subjectCategory);

	List<LibraryBookRecords> findByBookIdContainingIgnoreCase(String bookId);

	@Modifying
	long deleteByBookId(String bookId);

	boolean existsByBookId(String bookId);
	
	@Query(value = "UPDATE library_book_records SET status =?1 WHERE book_id = ?2", nativeQuery = true)
	@Modifying
	void updateStatus(String status, String bookId);

}
