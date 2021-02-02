package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.LibraryBookRecords;
/**
 * <h1>BookRecordsRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
@Repository
public interface LibraryBookRecordsRepository extends JpaRepository<LibraryBookRecords, Long> {
	
	List<LibraryBookRecords> findByTitleContainingIgnoreCase(String title);

	List<LibraryBookRecords> findByAuthorNameContainingIgnoreCase(String authorName);

	List<LibraryBookRecords> findBySubjectCategory(String subjectCategory);

	List<LibraryBookRecords> findByBookIdIgnoreCase(String bookId);

	@Modifying
	long deleteByBookId(String bookId);

	boolean existsByBookId(String bookId);
	
	List<LibraryBookRecords> findByBookIdContaining(String subjectCatedgory);
	
	@Query(value = "UPDATE library_book_records SET status =?1 WHERE book_id = ?2", nativeQuery = true)
	@Modifying
	void updateStatus(String status, String bookId);

	@Query(value = "SELECT DISTINCT subject_category FROM library_book_category_count", nativeQuery = true)
	List<String> getDistinctSubjectCategory();

}
