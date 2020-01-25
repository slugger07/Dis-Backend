package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.administration.model.LibraryBookCategoryCount;

@Repository
public interface LibraryBookCategoryCountRepository extends JpaRepository<LibraryBookCategoryCount, String> {

	List<LibraryBookCategoryCount> findBySubjectCategory(String subjectCategory);
	
	
//	@Transactional
//	long removeById(String id);
	
	@Modifying
	@Query(value = "UPDATE library_book_count SET count = count + 1 WHERE subject_category = ?1", nativeQuery = true)
	void updateCount(String subjectCategory);


	boolean existsBySubjectCategory(String subjectCategory);

	@Transactional
	long deleteBySubjectCategory(String subjectCategory);

}
