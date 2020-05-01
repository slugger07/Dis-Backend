package sgsits.cse.dis.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.Holiday;

@Repository("")
public interface HolidayRepository extends JpaRepository<Holiday,Integer>{
}
