package com.swgoh.repository;

import com.swgoh.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerritoryRepository extends JpaRepository<Territory, Long> {

    List<Territory> findByBattleId(Long battleId);
}
