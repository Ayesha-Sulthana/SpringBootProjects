package users.movies.UsersMoviesManagementSystem.Model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Movie{

	@Id
	private int movieId;
	private String movieName;
	private String genre;
	private int releaseYear;
	private double rating;
	public Movie(int movieId, String movieName, String genre, int releaseYear, double rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}	
	
	
}
