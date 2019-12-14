package quantumcity.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pollution")
public class Pollution implements Serializable{

	private static final long serialVersionUID = 5763450768902030193L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	private int ozone;
	private int particullateMatter;
	private int carbonMonoxide;
	private int sulfureDioxide;
	private int nitrogenDioxide;
	
	public Pollution(int ozone, int particullateMatter, int carbonMonoxide, int sulfureDioxide,
			int nitrogenDioxide) {
		this.ozone = ozone;
		this.particullateMatter = particullateMatter;
		this.carbonMonoxide = carbonMonoxide;
		this.sulfureDioxide = sulfureDioxide;
		this.nitrogenDioxide = nitrogenDioxide;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOzone() {
		return ozone;
	}

	public void setOzone(int ozone) {
		this.ozone = ozone;
	}

	public int getParticullateMatter() {
		return particullateMatter;
	}

	public void setParticullateMatter(int particullateMatter) {
		this.particullateMatter = particullateMatter;
	}

	public int getCarbonMonoxide() {
		return carbonMonoxide;
	}

	public void setCarbonMonoxide(int carbonMonoxide) {
		this.carbonMonoxide = carbonMonoxide;
	}

	public int getSulfureDioxide() {
		return sulfureDioxide;
	}

	public void setSulfureDioxide(int sulfureDioxide) {
		this.sulfureDioxide = sulfureDioxide;
	}

	public int getNitrogenDioxide() {
		return nitrogenDioxide;
	}

	public void setNitrogenDioxide(int nitrogenDioxide) {
		this.nitrogenDioxide = nitrogenDioxide;
	}

	@Override
	public String toString() {
		return "Pollution [id=" + id + ", ozone=" + ozone + ", particullateMatter=" + particullateMatter
				+ ", carbonMonoxide=" + carbonMonoxide + ", sulfureDioxide=" + sulfureDioxide + ", nitrogenDioxide="
				+ nitrogenDioxide + "]";
	}
	
	
	



}
