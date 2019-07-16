package com.pompidup.WildWarCircus.repositories;

import com.pompidup.WildWarCircus.entities.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubRepository extends JpaRepository<Pub, Long> {
}
