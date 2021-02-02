package sgsits.cse.dis.academics.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.academics.model.SemTimeTable;

@Repository
public interface SemTimeTableRepository extends JpaRepository<SemTimeTable, String> {

	Optional<SemTimeTable> findBySubjectCodeAndLectureTypeAndSession(String subjectCode, String lectureType, String session);

	Optional<SemTimeTable> findByIdAndSession(String id, String session);

	Optional<SemTimeTable> findBySessionAndSubjectCode(String session, String subjectCode);
}
