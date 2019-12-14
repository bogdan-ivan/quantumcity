package quantumcity.persistance.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quantumcity.persistance.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long>{

}
