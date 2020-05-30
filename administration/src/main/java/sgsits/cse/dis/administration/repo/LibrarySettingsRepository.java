package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.administration.model.LibrarySettings;
/**
 * <h1>LibrarySettingsRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
public interface LibrarySettingsRepository extends JpaRepository<LibrarySettings, String> {
	

}
