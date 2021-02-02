package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.academics.model.SemTimeTableSettings;

/**
 * <h1>SemTimeTableSettingsRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-FEB-2020
 */
@Repository
public interface SemTimeTableSettingsRepository extends JpaRepository<SemTimeTableSettings, String> {

}
