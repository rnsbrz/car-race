package com.spring.porscheRace.repository;

import com.spring.porscheRace.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RaceRepository extends JpaRepository<Race, Integer> {
    @Query("SELECT r FROM Race r WHERE r.id = :id")
    Race findById(int id);
}
