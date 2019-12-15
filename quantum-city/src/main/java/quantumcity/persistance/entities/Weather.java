package quantumcity.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
public class Weather implements Serializable{

	private static final long serialVersionUID = -1886763302069296331L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String date;
	
	private String hour;
	
	private String dewptm;
	
	private String hum;
	
	private String pressurem;
	
	private String tempm;
	
	private String visim;
	
	private String wdird;
	
	private String wspdm;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDewptm() {
		return dewptm;
	}

	public void setDewptm(String dewptm) {
		this.dewptm = dewptm;
	}

	public String getHum() {
		return hum;
	}

	public void setHum(String hum) {
		this.hum = hum;
	}

	public String getPressurem() {
		return pressurem;
	}

	public void setPressurem(String pressurem) {
		this.pressurem = pressurem;
	}

	public String getTempm() {
		return tempm;
	}

	public void setTempm(String tempm) {
		this.tempm = tempm;
	}

	public String getVisim() {
		return visim;
	}

	public void setVisim(String visim) {
		this.visim = visim;
	}

	public String getWdird() {
		return wdird;
	}

	public void setWdird(String wdird) {
		this.wdird = wdird;
	}

	public String getWspdm() {
		return wspdm;
	}

	public void setWspdm(String wspdm) {
		this.wspdm = wspdm;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Weather(String date, String hour, String dewptm) {
		this.date = date;
		this.hour = hour;
		this.dewptm = dewptm;
	}
	
	public Weather() {
		
	}
	
}
