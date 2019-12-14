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
	private int trafficLevel;
	
	public Traffic(int vehicleCount, float avgVehicle, String streeName, int trafficLevel) {
		this.vehicleCount = vehicleCount;
		this.avgVehicle = avgVehicle;
		this.streeName = streeName;
		this.trafficLevel = trafficLevel;
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
	public int getTrafficLevel() {
		return trafficLevel;
	}
	public void setTrafficLevel(int trafficLevel) {
		this.trafficLevel = trafficLevel;
	}
	@Override
	public String toString() {
		return "Traffic [id=" + id + ", vehicleCount=" + vehicleCount + ", avgVehicle=" + avgVehicle + ", streeName="
				+ streeName + "]";
	}
	
	
	
	
	

}
