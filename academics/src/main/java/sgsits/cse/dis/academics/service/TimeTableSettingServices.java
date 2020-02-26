package sgsits.cse.dis.academics.service;

import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.model.SemTimeTableSettings;

/**
 * <h1><b>TimeTableSettingServices</b> interface.</h1>
 * <p>This interface defines all the time table settings services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 25-FEB-2020.
 * @throws ConflictException.
 */
public interface TimeTableSettingServices {
	void saveSemTimeTableSettings(SemTimeTableSettings semTimeTableSettings,String modifiedBy) throws ConflictException;
	SemTimeTableSettings getSemTimeTableSettings();

}
