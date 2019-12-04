package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.LibraryThesisRecords;

@Repository
public interface LibraryThesisRecordsRepository extends JpaRepository<LibraryThesisRecords, Long> {

}
