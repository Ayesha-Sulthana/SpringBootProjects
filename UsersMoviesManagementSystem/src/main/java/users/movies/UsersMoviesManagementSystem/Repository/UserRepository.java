package users.movies.UsersMoviesManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import users.movies.UsersMoviesManagementSystem.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
