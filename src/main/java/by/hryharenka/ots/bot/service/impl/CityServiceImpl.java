package by.hryharenka.ots.bot.service.impl;

import by.hryharenka.ots.bot.entity.City;
import by.hryharenka.ots.bot.repository.CityRepository;
import by.hryharenka.ots.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City city) {
        if (cityRepository.existsById(city.getId())) {
            cityRepository.save(city);
        }
    }

    @Override
    public void delete(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City read(String name) {
        return cityRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }


}
