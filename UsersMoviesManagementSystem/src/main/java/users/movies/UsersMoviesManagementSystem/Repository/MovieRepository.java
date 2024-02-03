package users.movies.UsersMoviesManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import users.movies.UsersMoviesManagementSystem.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
