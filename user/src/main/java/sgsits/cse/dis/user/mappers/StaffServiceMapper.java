package sgsits.cse.dis.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.dtos.StaffBasicProfileDto;
import sgsits.cse.dis.user.model.StaffBasicProfile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffServiceMapper {

    @Mapping(target = "profilePicture", ignore = true)
    FacultyDataDto convertStaffBasicProfileIntoFacultyDataDto(
            final StaffBasicProfile staffBasicProfile);

    List<FacultyDataDto> convertStaffBasicProfileListIntoFacultyDataDtoList(
            final List<StaffBasicProfile> staffBasicProfileList);

    StaffBasicProfileDto convertStaffBasicProfileIntoStaffBasicProfileDto(
            final StaffBasicProfile staffBasicProfile);

    StaffBasicProfile convertStaffBasicProfileDtoIntoStaffBasicProfile(
            final StaffBasicProfileDto staffBasicProfileDto);


}
