package quantumcity.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "traffic")
public class Traffic implements Serializable {

	private static final long serialVersionUID = -5225250503938607190L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private int vehicleCount;
	private float avgVehicle;
	private String streeName;
	
	public Traffic(Long id, int vehicleCount, float avgVehicle, String streeName) {
		this.id = id;
		this.vehicleCount = vehicleCount;
		this.avgVehicle = avgVehicle;
		this.streeName = streeName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVehicleCount() {
		return vehicleCount;
	}
	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}
	public float getAvgVehicle() {
		return avgVehicle;
	}
	public void setAvgVehicle(float avgVehicle) {
		this.avgVehicle = avgVehicle;
	}
	public String getStreeName() {
		return streeName;
	}
	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}
	
	@Override
	public String toString() {
		return "Traffic [id=" + id + ", vehicleCount=" + vehicleCount + ", avgVehicle=" + avgVehicle + ", streeName="
				+ streeName + "]";
	}
	
	
	
	
	

}
