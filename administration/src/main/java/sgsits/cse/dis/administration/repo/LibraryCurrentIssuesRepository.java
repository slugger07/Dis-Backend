package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.administration.model.LibraryCurrentIssues;

public interface LibraryCurrentIssuesRepository extends JpaRepository<LibraryCurrentIssues, String>{
	
	@Query(value = "SELECT COUNT(*) FROM  library_current_issues WHERE username = ?1", nativeQuery = true)
	Long findByUsernameIgnoreCase(String username);
}
