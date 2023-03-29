package app;

public class Film {
	private Integer film_id;
	private String title;
	private String description;
	private Double rental_rate;
	private Integer rented_count;
	
	public Film(Integer id, String t) {
		this.film_id = id;
		this.title = t;
	}
	
	public boolean descContains(String s) {
		if(this.description.contains(s)) return true;
		return false;
	}
	
	public Integer getFilmID() {
		return this.film_id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Double getRentalRate() {
		return this.rental_rate;
	}
	
	public Integer getRentedCount() {
		return this.rented_count;
	}
	
	public void setCount(Integer count) {
		this.rented_count =  count;
	}
	
}
