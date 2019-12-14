package quantumcity.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quantumcity.persistance.entities.Traffic;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic,Long> {

}
