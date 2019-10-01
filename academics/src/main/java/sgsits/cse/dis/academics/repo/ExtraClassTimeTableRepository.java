package sgsits.cse.dis.academics.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.academics.model.ExtraClassTimeTable;

@Repository("extraClassTimeTable")
public interface ExtraClassTimeTableRepository extends JpaRepository<ExtraClassTimeTable, Long>{

	public List<ExtraClassTimeTable> findBySessionAndYearAndSemesterAndDate(String session, String year, String semester, Date date); 
}
