package sgsits.cse.dis.administration.repo;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.ResourceRequestCategory;

@Repository("resourceRequestCategoryRepository")
public interface ResourceRequestCategoryRepository extends JpaRepository<ResourceRequestCategory , Long> {

}
