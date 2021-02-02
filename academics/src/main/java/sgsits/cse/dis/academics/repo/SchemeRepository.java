package sgsits.cse.dis.academics.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.academics.model.Scheme;
/**
 * <h1>SchemeRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
@Repository("schemeRepository")
public interface SchemeRepository extends JpaRepository<Scheme, String> 
{
	public List<Scheme> findBySessionAndYearAndSemester(String session, String year, String semester);

	@Query(value = "SELECT DISTINCT subject_acronym FROM scheme", nativeQuery = true)
	public List<String> findDistinctSubjectAcronym();

	public List<Scheme> findByYearAndSemesterAndCourseId(String year, String sem, String courseId);

}
