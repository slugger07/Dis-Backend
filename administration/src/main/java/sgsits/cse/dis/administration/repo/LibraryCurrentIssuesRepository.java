package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.administration.model.LibraryCurrentIssues;
/**
 * <h1>LibraryCurrentIssuesRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
public interface LibraryCurrentIssuesRepository extends JpaRepository<LibraryCurrentIssues, String>{
	
	@Query(value = "SELECT COUNT(*) FROM  library_current_issues WHERE username = ?1", nativeQuery = true)
	Long findByUsernameIgnoreCase(String username);

	List<LibraryCurrentIssues> findByBookId(String bookId);

	List<LibraryCurrentIssues> findByThesisId(Long thesisId);

	@Modifying
	long deleteByBookId(String string);

	@Modifying
	long deleteByThesisId(long thesisId);
}
