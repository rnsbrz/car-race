package com.spring.porscheRace.service;

import com.spring.porscheRace.model.Car;
import com.spring.porscheRace.model.Race;

import java.util.List;

public interface RaceService {
    List<Race> getAll();
    void save(Race race);
    Race getById(int id);
    void update(Race race);
    void delete(int id);

}
