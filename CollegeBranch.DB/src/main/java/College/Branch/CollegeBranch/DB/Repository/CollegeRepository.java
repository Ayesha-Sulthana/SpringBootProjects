package College.Branch.CollegeBranch.DB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import College.Branch.CollegeBranch.DB.Model.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

}
