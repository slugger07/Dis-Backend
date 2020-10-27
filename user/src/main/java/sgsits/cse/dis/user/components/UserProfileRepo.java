package sgsits.cse.dis.user.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.*;
import sgsits.cse.dis.user.repo.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    private final UserAddressRepository userAddressRepository;

    private final UserOtherAchievementRepository userOtherAchievementRepository;

    private final ProfilePictureRepository profilePictureRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserProfileRepo.class);


    @Autowired
    public UserProfileRepo(final UserQualificationRepository userQualificationRepository,
                           final UserWorkExperienceRepository userWorkExperienceRepository,
                           final UserResearchWorkRepository userResearchWorkRepository,
                           final UserInternshipRepository userInternshipRepository,
                           final UserTechnicalActivityRepository userTechnicalActivityRepository,
                           final UserCulturalActivityAchievementRepository userCulturalActivityAchievementRepository,
                           final UserCompetitiveExamRepository userCompetitiveExamRepository,
                           final UserProjectRepository userProjectRepository,
                           final UserAddressRepository userAddressRepository,
                           final UserOtherAchievementRepository userOtherAchievementRepository,
                           final ProfilePictureRepository profilePictureRepository) {
        this.userQualificationRepository = userQualificationRepository;
        this.userWorkExperienceRepository = userWorkExperienceRepository;
        this.userResearchWorkRepository = userResearchWorkRepository;
        this.userInternshipRepository = userInternshipRepository;
        this.userTechnicalActivityRepository = userTechnicalActivityRepository;
        this.userCulturalActivityAchievementRepository = userCulturalActivityAchievementRepository;
        this.userCompetitiveExamRepository = userCompetitiveExamRepository;
        this.userProjectRepository = userProjectRepository;
        this.userAddressRepository = userAddressRepository;
        this.userOtherAchievementRepository = userOtherAchievementRepository;
        this.profilePictureRepository = profilePictureRepository;
    }

    public void addOrUpdateUserQualification(final UserQualification userQualification)
            throws InternalServerError {
        try {
            userQualificationRepository.save(userQualification);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user Qualification");
        }
    }

    public List<UserQualification> getUserQualification(final String userId) throws InternalServerError {
        try {
            return userQualificationRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user Qualification");
        }
    }

    public void deleteUserQualificationById(final Long userQualificationId) throws InternalServerError {

        try {
            userQualificationRepository.deleteById(userQualificationId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user Qualification");
        }
    }

    public void addOrUpdateUserWorkExperience(final UserWorkExperience userWorkExperience) throws InternalServerError {

        try {
            userWorkExperienceRepository.save(userWorkExperience);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user work experience");
        }

    }

    public List<UserWorkExperience> getUserWorkExperience(final String userId) throws InternalServerError {

        try {
            return userWorkExperienceRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user work experience");
        }
    }

    public void deleteUserWorkExperienceById(final Long workExperienceId) throws InternalServerError {

        try {
            userWorkExperienceRepository.deleteById(workExperienceId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user work experience");
        }

    }

    public void addOrUpdateUserResearchWork(final UserResearchWork userResearchWork) throws InternalServerError {
        try {
            userResearchWorkRepository.save(userResearchWork);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user research work");
        }

    }

    public List<UserResearchWork> getUserResearchWork(final String userId) throws InternalServerError {
        try {
            return userResearchWorkRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user research work");
        }

    }

    public void deleteUserResearchWorkById(final Long userResearchWorkId) throws InternalServerError {
        try {
            userResearchWorkRepository.deleteById(userResearchWorkId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user research work");
        }

    }

    public void addOrUpdateUserInternship(final UserInternship userInternship) throws InternalServerError {
        try {
            userInternshipRepository.save(userInternship);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user internship");
        }

    }

    public List<UserInternship> getUserInternship(final String userId) throws InternalServerError {

        try {
            return userInternshipRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot gst user internship");
        }

    }

    public void deleteUserInternshipById(final Long userInternshipId) throws InternalServerError {

        try {
            userInternshipRepository.deleteById(userInternshipId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user internship");
        }

    }

    public void addOrUpdateUserTechnicalActivity(final UserTechnicalActivity userTechnicalActivity) throws InternalServerError {

        try {
            userTechnicalActivityRepository.save(userTechnicalActivity);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user technical activity");
        }

    }

    public List<UserTechnicalActivity> getUserTechnicalActivity(final String userId) throws InternalServerError {

        try {
            return userTechnicalActivityRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user Technical activity");
        }

    }

    public void deleteUserTechnicalActivityById(final Long userTechnicalActivityId) throws InternalServerError {

        try {
            userTechnicalActivityRepository.deleteById(userTechnicalActivityId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user technical activity");
        }

    }

    public void addOrUpdateUserCulturalActivityAchievement(
            final UserCulturalActivityAchievement userCulturalActivityAchievement) throws InternalServerError {

        try {
            userCulturalActivityAchievementRepository.save(userCulturalActivityAchievement);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user cultural activity");
        }

    }

    public List<UserCulturalActivityAchievement> getUserCulturalActivityAchievement(final String userId) throws InternalServerError {

        try {
            return userCulturalActivityAchievementRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user cultural activity");
        }

    }

    public void deleteUserCulturalActivityAchievementById(final Long userCulturalActivityAchievementId) throws InternalServerError {

        try {
            userCulturalActivityAchievementRepository.deleteById(userCulturalActivityAchievementId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user cultural activity");
        }

    }

    public void addOrUpdateUserCompetitiveExam(final UserCompetitiveExam userCompetitiveExam)
            throws InternalServerError {

        try {
            userCompetitiveExamRepository.save(userCompetitiveExam);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update User Competitive Exam");
        }

    }

    public List<UserCompetitiveExam> getUserCompetitiveExam(final String userId)
            throws InternalServerError {

        try {
            return userCompetitiveExamRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get User Competitive Exam");
        }

    }

    public void deleteUserCompetitiveExamById(final Long userCompetitiveExamId)
            throws InternalServerError {

        try {
            userCompetitiveExamRepository.deleteById(userCompetitiveExamId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete User Competitive Exam");
        }

    }

    public void addOrUpdateUserProject(final UserProject userProject) throws InternalServerError {

        try {
            userProjectRepository.save(userProject);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user project");
        }
    }

    public List<UserProject> getUserProject(final String userId) throws InternalServerError {

        try {
            return userProjectRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user project");
        }
    }

    public void deleteUserProjectById(final Long userProjectId) throws InternalServerError {

        try {
            userProjectRepository.deleteById(userProjectId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user project");
        }
    }


    public void addOrUpdateUserAddress(final UserAddress userAddress) throws InternalServerError {

        try {
            userAddressRepository.save(userAddress);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user project");
        }

    }

    public List<UserAddress> getUserAddress(final String userId) throws InternalServerError {

        try {
            return userAddressRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user project");
        }
    }

    public void deleteUserAddressById(final Long userAddressId) throws InternalServerError {
        try {
            userProjectRepository.deleteById(userAddressId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user project");
        }
    }



    public void addOrUpdateUserOtherAchievement(final UserOtherAchievement userOtherAchievement) throws InternalServerError {

        try {
            userOtherAchievementRepository.save(userOtherAchievement);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update user project");
        }

    }

    public List<UserOtherAchievement> getUserOtherAchievement(final String userId) throws InternalServerError {

        try {
            return userOtherAchievementRepository.findByUserId(userId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot get user project");
        }
    }

    public void deleteUserOtherAchievementById(final Long userOtherAchievementId) throws InternalServerError {
        try {
            userProjectRepository.deleteById(userOtherAchievementId);
        } catch (Exception e) {
            throw new InternalServerError("Cannot delete user project");
        }
    }
    

    public UserAddress getUserAddressById(final long id) {
    
        Optional<UserAddress> userAddressOptional = userAddressRepository.findById(id);
        return userAddressOptional.orElse(null);
    }

    public UserOtherAchievement getUserOtherAchievementById(final long id) {

        Optional<UserOtherAchievement> userOtherAchievementOptional = userOtherAchievementRepository.findById(id);
        return userOtherAchievementOptional.orElse(null);
    }

    public UserCompetitiveExam getUserCompetitiveExamById(final long id) {

        Optional<UserCompetitiveExam> userCompetitiveExamOptional = userCompetitiveExamRepository.findById(id);
        return userCompetitiveExamOptional.orElse(null);
    }

    public UserCulturalActivityAchievement getUserCulturalActivityAchievementById(final long id) {

        Optional<UserCulturalActivityAchievement> userCulturalActivityAchievementOptional = userCulturalActivityAchievementRepository.findById(id);
        return userCulturalActivityAchievementOptional.orElse(null);
    }

    public UserInternship getUserInternshipById(final long id) {

        Optional<UserInternship> userInternshipOptional = userInternshipRepository.findById(id);
        return userInternshipOptional.orElse(null);
    }

    public UserProject getUserProjectById(final long id) {

        Optional<UserProject> userProjectOptional = userProjectRepository.findById(id);
        return userProjectOptional.orElse(null);
    }

    public UserQualification getUserQualificationById(final long id) {

        Optional<UserQualification> userQualificationOptional = userQualificationRepository.findById(id);
        return userQualificationOptional.orElse(null);
    }

    public UserResearchWork getUserResearchWorkById(final long id) {

        Optional<UserResearchWork> userResearchWorkOptional = userResearchWorkRepository.findById(id);
        return userResearchWorkOptional.orElse(null);
    }

    public UserTechnicalActivity getUserTechnicalActivityById(final long id) {

        Optional<UserTechnicalActivity> userTechnicalActivityOptional = userTechnicalActivityRepository.findById(id);
        return userTechnicalActivityOptional.orElse(null);
    }

    public UserWorkExperience getUserWorkExperienceById(final long id) {

        Optional<UserWorkExperience> userWorkExperienceOptional = userWorkExperienceRepository.findById(id);
        return userWorkExperienceOptional.orElse(null);
    }

    public void addOrUpdateUserProfilePicture(final ProfilePicture profilePicture)
            throws InternalServerError {

        try {
            profilePictureRepository.save(profilePicture);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update profile picture");
        }
    }

    public List<ProfilePicture> getActiveProfilePictureByUserId(final String userId)
            throws InternalServerError {

        try {
            List<ProfilePicture> profilePictures =
                    profilePictureRepository.findByUserIdAndStatus(userId, 1);
            LOGGER.info("ProfilePicture  --- " + Collections.singletonList(profilePictures));
            return profilePictures;
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update profile picture");
        }
    }


}
