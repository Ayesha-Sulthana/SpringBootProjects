package users.movies.UsersMoviesManagementSystem.DTO;

public class MovieDTO 
{

	private int movieId;
	private String movieName;
	private String genre;
	private int releaseYear;
	private double rating;
	public int getMovieId() {
		return movieId;
	}
	
	public MovieDTO()
	{
		
	}
	
	
	public MovieDTO(int movieId, String movieName, String genre, int releaseYear, double rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", releaseYear="
				+ releaseYear + ", rating=" + rating + "]";
	}
	
	
}
