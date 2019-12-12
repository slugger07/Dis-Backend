package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.administration.model.LibraryIssueHistory;

public interface LibraryIssueHistoryRepository extends JpaRepository<LibraryIssueHistory, String> {

	List<LibraryIssueHistory> findByBookId(String bookId);

	List<LibraryIssueHistory> findByThesisId(Long thesisId);

	List<LibraryIssueHistory> findByUsername(String username);



}
