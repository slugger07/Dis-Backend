package sgsits.cse.dis.user.serviceImpl;


import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.List;

@Service
class UserProfileServiceImpl implements UserProfileService {


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {
        return null;
    }

    public UserProfileDto addUserProfileElement(final UserProfileDto userProfileDto) {
        return null;
    }

    @Override
    public void deleteUserProfileElementById(final Long id, final String userId) {

    }

   /* UserProfileServiceImpl(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    @Override
    public List<UserWorkExperienceDto> getUserWorkExperiences(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserCompetitiveExamDto> getUserCompetitiveExams(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserTechnicalActivityDto> getUserTechnicalActivities(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserQualificationDto> getUserQualifications(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserInternshipDto> getUserInternships(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserC ulturalActivityAchievementDto> getUserCulturalActivityAchievements(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserProjectDto> getUserProjects(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }

    @Override
    public List<UserResearchWork> getUserResearchWorks(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);
        return userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));
    }*/
}
