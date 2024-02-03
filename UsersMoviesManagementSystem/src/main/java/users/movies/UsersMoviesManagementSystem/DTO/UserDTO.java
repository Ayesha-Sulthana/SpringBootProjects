package users.movies.UsersMoviesManagementSystem.DTO;

import java.util.List;


import users.movies.UsersMoviesManagementSystem.Model.Movie;

public class UserDTO 
{

	private int userId;
	private String username;
	private String email;
	private List<Movie> watchedMovies;

	public UserDTO()
	{
		
	}
	
	public UserDTO(int userId, String username, String email, List<Movie> watchedMovies) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.watchedMovies = watchedMovies;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Movie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(List<Movie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", watchedMovies="
				+ watchedMovies + "]";
	}
	
}
