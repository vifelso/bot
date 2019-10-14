package by.hryharenka.ots.bot.controller;

import by.hryharenka.ots.bot.entity.City;
import by.hryharenka.ots.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/{name}", produces = "application/json")
    public City getCity(@PathVariable String name) {
        return cityService.read(name);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<City> getCities() {
        return cityService.findAll();
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public void saveCity(@Valid @RequestBody City city) {
        cityService.save(city);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCityById(@PathVariable() long id) {
        cityService.delete(id);
    }

    @PutMapping(value = "/edit/{id}", consumes = "application/json")
    public void editCity(@PathVariable() long id, @Valid @RequestBody City city) {
        city.setId(id);
        cityService.update(city);
    }

}