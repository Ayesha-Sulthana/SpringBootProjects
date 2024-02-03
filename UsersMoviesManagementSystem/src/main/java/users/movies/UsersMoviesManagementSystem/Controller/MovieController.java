package users.movies.UsersMoviesManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import users.movies.UsersMoviesManagementSystem.DTO.MovieDTO;
import users.movies.UsersMoviesManagementSystem.Model.Movie;
import users.movies.UsersMoviesManagementSystem.Service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@RequestMapping(value = "/Movie/add", method = RequestMethod.POST)
	public boolean addMovie(@RequestBody MovieDTO movieDto)
	{
		return movieService.addMovie(movieDto);
	}
	
	@GetMapping("/Movie/getAllMovies")
	public List<MovieDTO> getAllMovies()
	{
		return movieService.getAllMovies();
	}
	
	@GetMapping("/Movie/get/{id}")
	public MovieDTO getMovieById(@PathVariable int id)
	{
		return movieService.getMovieById(id);	
	}

	@GetMapping("/Movie/getMoviesSortedByRating")
	public List<MovieDTO> getMoviesSortedByRating()
	{
		return movieService.getMoviesSortedByRating();
	}
	
	@GetMapping("/Movie/getMoviesSortedByReleaseYear")
	public List<MovieDTO> getMoviesSortedByReleaseYear()
	{
		return movieService.getMoviesSortedByReleaseYear();
	}
	
}
