package com.pompidup.WildWarCircus.repositories;

import com.pompidup.WildWarCircus.entities.Crasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrasseRepository extends JpaRepository<Crasse, Long> {
}
