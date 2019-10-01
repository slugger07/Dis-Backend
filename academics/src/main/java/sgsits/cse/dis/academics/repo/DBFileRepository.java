package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.academics.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
