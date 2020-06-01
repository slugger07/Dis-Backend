package sgsits.cse.dis.user.service;

import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.*;

import java.util.List;

@Component
public interface StudentService {

    StudentBasicProfileDto getStudentBasicProfile(final String userId) throws InternalServerError;

    void addOrUpdateStudentBasicProfile(final StudentBasicProfileDto studentBasicProfileDto) throws InternalServerError;

    List<PgProjectDetailDto> getPgProjectDetails(final String userId);

    List<StudentAttendanceDto> getStudentAttendanceRecord(final String userId);

    List<StudentLeaveDto> getStudentLeaveRecord(final String userId);

    List<StudentPlacementDto> getStudentPlacementRecord(final String userId);

    List<UgProjectDetailDto> geUgProjectDetails(final String userId);

}
