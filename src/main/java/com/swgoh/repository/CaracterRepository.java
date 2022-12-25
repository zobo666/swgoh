package com.swgoh.repository;

import com.swgoh.entity.Caracter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaracterRepository extends JpaRepository<Caracter, Long> {

    Optional<Caracter> findByDefId(String defId);
}
