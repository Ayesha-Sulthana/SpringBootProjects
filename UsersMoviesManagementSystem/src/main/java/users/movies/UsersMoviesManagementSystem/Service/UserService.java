package users.movies.UsersMoviesManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.movies.UsersMoviesManagementSystem.DTO.UserDTO;
import users.movies.UsersMoviesManagementSystem.Model.Movie;
import users.movies.UsersMoviesManagementSystem.Model.User;
import users.movies.UsersMoviesManagementSystem.Repository.MovieRepository;
import users.movies.UsersMoviesManagementSystem.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieRepository moviesRepository;

	public boolean addUser(UserDTO userDto) 
	{
		User user = convertDTOtoEntity(userDto);
		Optional<User> userr= userRepository.findById(user.getUserId());
		if(userr.isPresent())
			return false;
		else
		{
			userRepository.save(user);
			return true;
		}
	}


	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userDtos = new ArrayList<>();
		for(User u : users)
		{
			UserDTO userDto = convertEntityToDTO(u);
			userDtos.add(userDto);
		}
		return userDtos;
	}

	public UserDTO getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			User u = user.get();
			return convertEntityToDTO(u);
		}
		else
			return null;
	}

//	public List<Movie> getMoviesByuserId(int userId) 
//	{
//		Optional<User> user = userRepository.findById(userId);
//		List<Movie> movies = new ArrayList<>();
//		if(user.isPresent())
//		{
//			User u = user.get();
//			movies = u.getWatchedMovies();
//        }
//        return movies;
//	}

	public List<UserDTO> getUsersByWatchedMovie(int movieId) {
		
		
		Optional<Movie> movie = moviesRepository.findById(movieId);
		List<UserDTO> watchedUsers = new ArrayList<>();
		if(movie.isPresent())
		{
			List<User> existingUsers = userRepository.findAll();
			for(User usr : existingUsers)
			{
				List<Movie> movies = usr.getWatchedMovies();
				for(Movie mov: movies)
				{
					if(mov.getMovieId()==movieId)
						watchedUsers.add(convertEntityToDTO(usr));
						
				}
			}
		}
		return watchedUsers;
		
	}
	
	private User convertDTOtoEntity(UserDTO userDto) {
		return new User(userDto.getUserId(),userDto.getUsername(),userDto.getEmail(),userDto.getWatchedMovies());
		
	}
	
	private UserDTO convertEntityToDTO(User u) {
		return new UserDTO(u.getUserId(),u.getUsername(),u.getEmail(),u.getWatchedMovies());
	}
}
