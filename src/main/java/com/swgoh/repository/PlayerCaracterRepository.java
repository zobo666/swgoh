package com.swgoh.repository;

import com.swgoh.entity.PlayerCaracter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerCaracterRepository extends JpaRepository<PlayerCaracter, Long> {

    Optional<PlayerCaracter> findByPlayerIdAndCaracterId(Long playerId, Long caracterId);
}
