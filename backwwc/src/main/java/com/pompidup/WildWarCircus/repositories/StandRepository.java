package com.pompidup.WildWarCircus.repositories;

import com.pompidup.WildWarCircus.entities.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {
}
