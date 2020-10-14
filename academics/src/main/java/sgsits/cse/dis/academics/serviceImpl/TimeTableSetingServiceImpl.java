package sgsits.cse.dis.academics.serviceImpl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.model.SemTimeTableSettings;
import sgsits.cse.dis.academics.repo.SemTimeTableSettingsRepository;
import sgsits.cse.dis.academics.service.TimeTableSettingServices;

/**
 * <h1><b>TimeTableSetingServiceImpl</b> class.</h1>
 * <p>This class contains implementation of all the time table settings
 *  services which are defined in the <b>TimeTableSettingServices</b> interface.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 25-FEB-2020
 * @throws ConflictException
 * @inheritDoc
 */
@Service
public class TimeTableSetingServiceImpl implements TimeTableSettingServices{
	
	@Autowired
	SemTimeTableSettingsRepository semTimeTableSettingsRepository;

	@Override
	public void saveSemTimeTableSettings(SemTimeTableSettings semTimeTableSettings,String modifiedBy) throws ConflictException {
		semTimeTableSettings.setModifiedBy(modifiedBy);
		semTimeTableSettings.setModifiedDate(Instant.now());
		if(semTimeTableSettingsRepository.save(semTimeTableSettings).equals(null))
			throw new ConflictException("Unable to update settings");
	}

	@Override
	public SemTimeTableSettings getSemTimeTableSettings() {
			return semTimeTableSettingsRepository.findAll().get(0);
	}

}
