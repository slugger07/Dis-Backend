package sgsits.cse.dis.user.mappers;

import org.mapstruct.Mapper;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.model.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserProfileDtoMapper {
    
    UserWorkExperienceDto convertUserWorkExperienceModelIntoDto(
            final UserWorkExperience userWorkExperience);
    
    UserWorkExperience convertUserWorkExperienceDtoIntoModel(
            final UserWorkExperienceDto userWorkExperienceDto);

    List<UserWorkExperienceDto> convertUserWorkExperienceListModelIntoDto(
            final List<UserWorkExperience> userWorkExperienceList);

    List<UserWorkExperience> convertUserWorkExperienceListDtoIntoModel(
            final List<UserWorkExperienceDto> userWorkExperienceDtoList);



    UserTechnicalActivityDto convertUserTechnicalActivityModelIntoDto(
            final UserTechnicalActivity userTechnicalActivity);
    
    UserTechnicalActivity convertUserTechnicalActivityDtoIntoModel(
            final UserTechnicalActivityDto userTechnicalActivityDto);

    List<UserTechnicalActivityDto> convertUserTechnicalActivityListModelIntoDto(
            final List<UserTechnicalActivity> userTechnicalActivityList);

    List<UserTechnicalActivity> convertUserTechnicalActivityListDtoIntoModel(
            final List<UserTechnicalActivityDto> userTechnicalActivityDtoList);



    UserResearchWorkDto convertUserResearchWorkModelIntoDto(
            final UserResearchWork userResearchWork);

    UserResearchWork convertUserResearchWorkDtoIntoModel(
            final UserResearchWorkDto userResearchWorkDto);

    List<UserResearchWorkDto> convertUserResearchWorkListModelIntoDto(
            final List<UserResearchWork> userResearchWorkList);

    List<UserResearchWork> convertUserResearchWorkListDtoIntoModel(
            final List<UserResearchWorkDto> userResearchWorkDtoList);



    UserQualificationDto convertUserQualificationModelIntoDto(
            final UserQualification userQualification);

    UserQualification convertUserQualificationDtoIntoModel(
            final UserQualificationDto userQualificationDto);

    List<UserQualificationDto> convertUserQualificationListModelIntoDto(
            final List<UserQualification> userQualificationList);

    List<UserQualification> convertUserQualificationListDtoIntoModel(
            final List<UserQualificationDto> userQualificationDtoList);



    UserInternshipDto convertUserInternshipModelIntoDto(
            final UserInternship userInternship);

    UserInternship convertUserInternshipDtoIntoModel(
            final UserInternshipDto userInternshipDto);

    List<UserInternshipDto> convertUserInternshipListModelIntoDto(
            final List<UserInternship> userInternshipList);

    List<UserInternship> convertUserInternshipListDtoIntoModel(
            final List<UserInternshipDto> userInternshipDtoList);


    
    UserProjectDto convertUserProjectModelIntoDto(
            final UserProject userProject);

    UserProject convertUserProjectDtoIntoModel(
            final UserProjectDto userProjectDto);

    List<UserProjectDto> convertUserProjectListModelIntoDto(
            final List<UserProject> userProjectList);

    List<UserProject> convertUserProjectListDtoIntoModel(
            final List<UserProjectDto> userProjectDtoList);



    UserCulturalActivityAchievementDto convertUserCulturalActivityAchievementModelIntoDto(
            final UserCulturalActivityAchievement userCulturalActivityAchievement);

    UserCulturalActivityAchievement convertUserCulturalActivityAchievementDtoIntoModel(
            final UserCulturalActivityAchievementDto userCulturalActivityAchievementDto);

    List<UserCulturalActivityAchievementDto> convertUserCulturalActivityAchievementListModelIntoDto(
            final List<UserCulturalActivityAchievement> userCulturalActivityAchievementList);

    List<UserCulturalActivityAchievement> convertUserCulturalActivityAchievementListDtoIntoModel(
            final List<UserCulturalActivityAchievementDto> userCulturalActivityAchievementDtoList);



    UserCompetitiveExamDto convertUserCompetitiveExamModelIntoDto(
            final UserCompetitiveExam userCompetitiveExam);

    UserCompetitiveExam convertUserCompetitiveExamDtoIntoModel(
            final UserCompetitiveExamDto userCompetitiveExamDto);

    List<UserCompetitiveExamDto> convertUserCompetitiveExamListModelIntoDto(
            final List<UserCompetitiveExam> userCompetitiveExamList);

    List<UserCompetitiveExam> convertUserCompetitiveExamListDtoIntoModel(
            final List<UserCompetitiveExamDto> userCompetitiveExamDtoList);
    
    

    UserAddressDto convertUserAddressModelIntoDto(
            final UserAddress userAddress);

    UserAddress convertUserAddressDtoIntoModel(
            final UserAddressDto userAddressDto);

    List<UserAddressDto>  convertUserAddressListModelIntoDto(
            final List<UserAddress> userAddressList);

    List<UserAddress> convertUserAddressListDtoIntoModel(
            final List<UserAddressDto> userAddressDtoList);



    UserOtherAchievementDto convertUserOtherAchievementModelIntoDto(
            final UserOtherAchievement userOtherAchievement);

    UserOtherAchievement convertUserOtherAchievementDtoIntoModel(
            final UserOtherAchievementDto userOtherAchievementDto);

    List<UserOtherAchievementDto>  convertUserOtherAchievementListModelIntoDto(
            final List<UserOtherAchievement> userOtherAchievementList);

    List<UserOtherAchievement> convertUserOtherAchievementListDtoIntoModel(
            final List<UserOtherAchievementDto> userOtherAchievementDtoList);


}
