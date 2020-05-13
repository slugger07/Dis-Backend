package sgsits.cse.dis.user.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.model.*;
import sgsits.cse.dis.user.repo.*;

import java.util.List;

@Component
public class UserProfileRepo {

     private final UserQualificationRepository userQualificationRepository;

     private final UserWorkExperienceRepository userWorkExperienceRepository;

     private final UserResearchWorkRepository userResearchWorkRepository;

     private final UserInternshipRepository userInternshipRepository;

     private final UserTechnicalActivityRepository userTechnicalActivityRepository;

     private final UserCulturalActivityAchievementRepository userCulturalActivityAchievementRepository;

     private final UserCompetitiveExamRepository userCompetitiveExamRepository;

     private final UserProjectRepository userProjectRepository;


     @Autowired
     public UserProfileRepo(final UserQualificationRepository userQualificationRepository,
                            final UserWorkExperienceRepository userWorkExperienceRepository,
                            final UserResearchWorkRepository userResearchWorkRepository,
                            final UserInternshipRepository userInternshipRepository,
                            final UserTechnicalActivityRepository userTechnicalActivityRepository,
                            final UserCulturalActivityAchievementRepository userCulturalActivityAchievementRepository,
                            final UserCompetitiveExamRepository userCompetitiveExamRepository,
                            final UserProjectRepository userProjectRepository) {
          this.userQualificationRepository = userQualificationRepository;
          this.userWorkExperienceRepository = userWorkExperienceRepository;
          this.userResearchWorkRepository = userResearchWorkRepository;
          this.userInternshipRepository = userInternshipRepository;
          this.userTechnicalActivityRepository = userTechnicalActivityRepository;
          this.userCulturalActivityAchievementRepository = userCulturalActivityAchievementRepository;
          this.userCompetitiveExamRepository = userCompetitiveExamRepository;
          this.userProjectRepository = userProjectRepository;
     }

     public void addOrUpdateUserQualification(final UserQualification userQualification) {
          userQualificationRepository.save(userQualification);
     }

     public List<UserQualification> getUserQualification(final String userId) {
          return userQualificationRepository.findByUserId(userId);
     }

     public void deleteUserQualificationById(final Long userQualificationId){
          userQualificationRepository.deleteById(userQualificationId);
     }

     public void addOrUpdateUserWorkExperience(final UserWorkExperience userWorkExperience) {
          userWorkExperienceRepository.save(userWorkExperience);
     }

     public List<UserWorkExperience> getUserWorkExperience(final String userId) {
          return userWorkExperienceRepository.findByUserId(userId);
     }

     public void deleteUserWorkExperienceById(final Long workExperienceId){
          userWorkExperienceRepository.deleteById(workExperienceId);
     }

     public void addOrUpdateUserResearchWork(final UserResearchWork userResearchWork) {
          userResearchWorkRepository.save(userResearchWork);
     }

     public List<UserResearchWork> getUserResearchWork(final String userId) {
          return userResearchWorkRepository.findByUserId(userId);
     }

     public void deleteUserResearchWorkById(final Long userResearchWorkId){
          userResearchWorkRepository.deleteById(userResearchWorkId);
     }

     public void addOrUpdateUserInternship(final UserInternship userInternship) {
          userInternshipRepository.save(userInternship);
     }

     public List<UserInternship> getUserInternship(final String userId) {
          return userInternshipRepository.findByUserId(userId);
     }

     public void deleteUserInternshipById(final Long userInternshipId){
          userInternshipRepository.deleteById(userInternshipId);
     }

     public void addOrUpdateUserTechnicalActivity(final UserTechnicalActivity userTechnicalActivity) {
          userTechnicalActivityRepository.save(userTechnicalActivity);
     }

     public List<UserTechnicalActivity> getUserTechnicalActivity(final String userId) {
          return userTechnicalActivityRepository.findByUserId(userId);
     }

     public void deleteUserTechnicalActivityById(final Long userTechnicalActivityId){
          userTechnicalActivityRepository.deleteById(userTechnicalActivityId);
     }

     public void addOrUpdateUserCulturalActivityAchievement(
             final UserCulturalActivityAchievement userCulturalActivityAchievement) {
          userCulturalActivityAchievementRepository.save(userCulturalActivityAchievement);
     }

     public List<UserCulturalActivityAchievement> getUserCulturalActivityAchievement(final String userId) {
          return userCulturalActivityAchievementRepository.findByUserId(userId);
     }

     public void deleteUserCulturalActivityAchievementById(final Long userCulturalActivityAchievementId){
          userCulturalActivityAchievementRepository.deleteById(userCulturalActivityAchievementId);
     }

     public void addOrUpdateUserCompetitiveExam(final UserCompetitiveExam userCompetitiveExam) {
          userCompetitiveExamRepository.save(userCompetitiveExam);
     }

     public List<UserCompetitiveExam> getUserCompetitiveExam(final String userId) {
          return userCompetitiveExamRepository.findByUserId(userId);
     }

     public void deleteUserCompetitiveExamById(final Long userCompetitiveExamId){
          userCompetitiveExamRepository.deleteById(userCompetitiveExamId);
     }

     public void addOrUpdateUserProject(final UserProject userProject) {
          userProjectRepository.save(userProject);
     }

     public List<UserProject> getUserProject(final String userId) {
          return userProjectRepository.findByUserId(userId);
     }

     public void deleteUserProjectById(final Long userProjectId){
          userProjectRepository.deleteById(userProjectId);
     }

}
