package sgsits.cse.dis.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.User;

/**
 * The interface User repository.
 */
@Repository("userServiceRepository")
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findByUsername(final String username);

    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    Boolean existsByUsername(final String username);

    /**
     * Exists by email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    Boolean existsByEmail(final String email);

    /**
     * Exists by mobile no boolean.
     *
     * @param mobileNo the mobiel no
     * @return the boolean
     */
    Boolean existsByMobileNo(final long mobileNo);

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    Optional<User> findByEmail(final String email);

    /**
     * Find by mobile no optional.
     *
     * @param mobileNo the mobile no
     * @return the optional
     */
    Optional<User> findByMobileNo(final long mobileNo);

    List<User> findAllByEnabledAndUserTypeNot(boolean enabled, String userType);

    /**
     * Find all by username list.
     *
     * @param usernameList the username list
     * @return the list
     */
    List<User> findAllByUsernameIn(final List<String> usernameList);

    /**
     * Find all by username not containing list.
     *
     * @param usernameList the username list
     * @return the list
     */
    List<User> findAllByUserTypeInAndUsernameNotIn(final List<String> typeList, final List<String> usernameList);

    /**
     * Find all by user type list.
     *
     * @param typeList the type list
     * @return the list
     */
    List<User> findAllByUserTypeIn(final List<String> typeList);
}