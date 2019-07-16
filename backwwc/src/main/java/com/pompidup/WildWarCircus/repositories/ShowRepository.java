package com.pompidup.WildWarCircus.repositories;

import com.pompidup.WildWarCircus.entities.Shoow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Shoow, Long> {
}
