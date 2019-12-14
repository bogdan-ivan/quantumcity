package quantumcity.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import quantumcity.persistance.entities.Parking;

public interface ParkingRepository extends JpaRepository<Parking,Long>{

}
