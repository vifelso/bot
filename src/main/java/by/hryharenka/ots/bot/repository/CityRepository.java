package by.hryharenka.ots.bot.repository;

import by.hryharenka.ots.bot.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    City findByNameIgnoreCase(String name);
}
