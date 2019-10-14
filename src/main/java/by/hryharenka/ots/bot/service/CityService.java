package by.hryharenka.ots.bot.service;

import by.hryharenka.ots.bot.entity.City;

import java.util.List;

public interface CityService {
    void save(City city);
    void update(City city);
    void delete(long id);
    City read(String name);
    List<City> findAll();
}
