package app;

public class Inventory {
	private Integer inventory_id;
	private Integer film_id;

	
	public Inventory(Integer id, Integer id2 ) {
		this.film_id = id;
		this.inventory_id = id2;
	}
	
	public Integer getFilmID() {
		return this.film_id;
	}
	
	public Integer getInventoryID() {
		return inventory_id;
	}
}



