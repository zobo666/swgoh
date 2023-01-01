package com.swgoh.repository;

import com.swgoh.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findOperationByTerritoryId(Long territoryId);
}
