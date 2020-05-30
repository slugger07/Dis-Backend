package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.administration.model.LibrarySettings;

public interface LibrarySettingsRepository extends JpaRepository<LibrarySettings, String> {
	

}
