package com.swgoh.repository;

import com.swgoh.entity.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {

    public Optional<Guild> findBySwgohId(String swgohId);
}
