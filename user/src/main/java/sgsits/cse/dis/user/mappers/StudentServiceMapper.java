package sgsits.cse.dis.user.mappers;

import org.mapstruct.Mapper;
import sgsits.cse.dis.user.dtos.StudentBasicProfileDto;
import sgsits.cse.dis.user.model.StudentProfile;

@Mapper(componentModel = "spring")
public interface StudentServiceMapper {

    StudentBasicProfileDto convertStudentBasicProfileModelIntoDto(
            final StudentProfile studentProfile);

    StudentProfile convertStudentBasicProfileDtoIntoModel(
            final StudentBasicProfileDto studentBasicProfileDto);
}

