package users.movies.UsersMoviesManagementSystem.Model;

import java.util.List;

import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;

@Entity
public class User 
{
	@Id
	private int userId;
	private String username;
	private String email;
	
	@ManyToMany
	@JoinTable
	(
	name = "User_Movies",
	joinColumns = @JoinColumn(name = "userId"),
	inverseJoinColumns = @JoinColumn(name = "movieId")
	)
	private List<Movie> watchedMovies;
	
	public User()
	{
		
	}

	public User(int userId, String username, String email, List<Movie> watchedMovies) {
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
