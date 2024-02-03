package users.movies.UsersMoviesManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import users.movies.UsersMoviesManagementSystem.DTO.UserDTO;
import users.movies.UsersMoviesManagementSystem.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/User/add", method = RequestMethod.POST)
	public boolean addUser(@RequestBody UserDTO userDto)
	{
		return userService.addUser(userDto);
	}
	
	
	@GetMapping("/User/getAllUsers")
	public List<UserDTO> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/User/get/{id}")
	public UserDTO getUserById(@PathVariable int id)
	{
		return userService.getUserById(id);	
	}
	
//	@GetMapping("/User/watchedmovies/{id}")
//	public List<Movie> getMoviesByUserId(@PathVariable int userId)
//	{
//		return userService.getMoviesByuserId(userId);
//	}
	
	@GetMapping("/watched-movies/{movieId}")
    public List<UserDTO> getUsersByWatchedMovie(@PathVariable int movieId) {
        return userService.getUsersByWatchedMovie(movieId);
    }
	
}
