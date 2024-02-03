package College.Branch.CollegeBranch.DB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import College.Branch.CollegeBranch.DB.Model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
