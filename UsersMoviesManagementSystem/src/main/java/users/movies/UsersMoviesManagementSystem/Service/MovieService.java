package users.movies.UsersMoviesManagementSystem.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.movies.UsersMoviesManagementSystem.DTO.MovieDTO;
import users.movies.UsersMoviesManagementSystem.Model.Movie;
import users.movies.UsersMoviesManagementSystem.Repository.MovieRepository;

@Service
public class MovieService {

	
	@Autowired
	MovieRepository movieRepository;
	
	Comparator<Movie> ratingCompar = new Comparator<Movie>()
	{
		public int compare(Movie mov1, Movie mov2) 
		{
	        if(mov1.getRating()<mov2.getRating())
	        	return 1;
	        else
	        	return -1;
	        
	    }
	};
	
	Comparator<Movie> releaseCompar = new Comparator<Movie>()
	{
		public int compare(Movie mov1, Movie mov2) 
		{
	        if(mov1.getReleaseYear()<mov2.getReleaseYear())
	        	return 1;
	        else
	        	return -1;
	        
	    }
	};

	public boolean addMovie(MovieDTO movieDto) 
	{
		Movie movie = convertDTOtoEntity(movieDto);
		Optional<Movie> mov= movieRepository.findById(movie.getMovieId());
		if(mov.isPresent())
			return false;
		else
		{
			movieRepository.save(movie);
			return true;
		}
	}

	
	public List<MovieDTO> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		List<MovieDTO> movieDtos = new ArrayList<>();
		for(Movie m : movies)
		{
			movieDtos.add(convertEntityToDto(m));
		}
		return movieDtos;
	}

	public MovieDTO getMovieById(int id) {
		
		Optional<Movie> movie = movieRepository.findById(id);
		if(movie.isPresent())
		{
			Movie mov = movie.get();
			return convertEntityToDto(mov);
		}
		else
			return null;
	}

	public List<MovieDTO> getMoviesSortedByRating() 
	{
		List<Movie> movies= movieRepository.findAll();
		Collections.sort(movies ,ratingCompar);
		List<MovieDTO> movieDtos = new ArrayList<>();
		for(Movie m:movies)
		{
			movieDtos.add(convertEntityToDto(m));
		}
		return movieDtos;
		
	}
	
	public List<MovieDTO> getMoviesSortedByReleaseYear() 
	{
		List<Movie> movies= movieRepository.findAll();
		Collections.sort(movies,releaseCompar);
		List<MovieDTO> movieDtos = new ArrayList<>();
		for(Movie m:movies)
		{
			movieDtos.add(convertEntityToDto(m));
		}
		return movieDtos;
	}
	
	private Movie convertDTOtoEntity(MovieDTO movieDto) {
		return new Movie(movieDto.getMovieId(), movieDto.getMovieName(),movieDto.getGenre(),
				movieDto.getReleaseYear(), movieDto.getRating());
	}
	
	private MovieDTO convertEntityToDto(Movie m) {
		
		return new MovieDTO(m.getMovieId(),m.getMovieName(),m.getGenre(),m.getReleaseYear(),m.getRating());
	}
	
}
