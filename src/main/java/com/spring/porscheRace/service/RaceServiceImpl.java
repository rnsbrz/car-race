package com.spring.porscheRace.service;

import com.spring.porscheRace.model.Race;
import com.spring.porscheRace.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService{
    public final RaceRepository raceRepository;
    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    @Override
    public void save(Race race) {
        raceRepository.save(race);
    }

    @Override
    public Race getById(int id) {
        return raceRepository.findById(id);
    }

    @Override
    public void update(Race race) {
        raceRepository.save(race);
    }

    @Override
    public void delete(int id) {
        raceRepository.deleteById(id);
    }
}
