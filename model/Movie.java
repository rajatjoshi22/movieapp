package com.movieapp.model;

public class Movie {

	private String name;
	private 	Integer  ratings;
	private String language;
	private String category;
	private String director;
	private String actor;
	private String actress;
	private String date;
	private Double price;
	private String city;
	private Integer movieId;
	public Movie() {
		super();
	}
	public Movie(String name, Integer ratings, String language, String category, String director, String actor,
			String actress, String date, Double price, String city, Integer movieId) {
		super();
		this.name = name;
		this.ratings = ratings;
		this.language = language;
		this.category = category;
		this.director = director;
		this.actor = actor;
		this.actress = actress;
		this.date = date;
		this.price = price;
		this.city = city;
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", ratings=" + ratings + ", language=" + language + ", category=" + category
				+ ", director=" + director + ", actor=" + actor + ", actress=" + actress + ", date=" + date + ", price="
				+ price + ", city=" + city + ", movieId=" + movieId + "]";
	}
}