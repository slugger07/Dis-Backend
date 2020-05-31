package sgsits.cse.dis.user.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.repo.StudentProfileRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class StudentProfileRepo {

    private final StudentProfileRepository studentProfileRepository;

    @Autowired
    public StudentProfileRepo(final StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    public StudentProfile getStudentProfileUsingUserId(final String userId) throws InternalServerError {

        try {
            final Optional<StudentProfile> optionalStudentProfile =
                    studentProfileRepository.findByUserId(userId);

            if(optionalStudentProfile.isPresent()) {
                return optionalStudentProfile.get();
            } else {
                throw new NoSuchElementException("Student with the given userId not found");
            }
        } catch (Exception e) {
            throw new InternalServerError("Could not fetch Student Profile");
        }
    }

    public void addOrUpdateStudentProfile(final StudentProfile studentProfile) throws InternalServerError {

        try {
            studentProfileRepository.save(studentProfile);
        } catch (Exception e) {
            throw new InternalServerError("Cannot add or update student Profile");
        }
    }

}
