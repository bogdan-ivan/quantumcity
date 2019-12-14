package quantumcity.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "parking")
public class Parking implements Serializable{

	private static final long serialVersionUID = 6768579011921484664L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private String name;
	
	private Integer availableSlots;
	
	private Integer occupiedSlots;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvailableSlots() {
		return availableSlots;
	}

	public Integer getOccupiedSlots() {
		return occupiedSlots;
	}

	public void setOccupiedSlots(Integer occupiedSlots) {
		this.occupiedSlots = occupiedSlots;
	}
	
	public boolean hasAvailableSlots() {
		return availableSlots.equals(occupiedSlots);
	}
	
	public void park() {
		occupiedSlots++;
	}
	
	public void removeCar() {
		occupiedSlots--;
	}
	
	public Parking(String name, Integer availableSlots) {
		this.name = name;
		this.availableSlots = availableSlots;
		this.occupiedSlots = 0;
	}
	
	public Parking() {}
	
}
