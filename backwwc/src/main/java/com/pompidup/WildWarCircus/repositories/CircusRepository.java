package com.pompidup.WildWarCircus.repositories;

import com.pompidup.WildWarCircus.entities.Circus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircusRepository extends JpaRepository<Circus, Long> {
}
