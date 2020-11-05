package com.simplechain.webapp.backend.repos;

import com.simplechain.webapp.backend.models.Block;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepo extends JpaRepository<Block, Long> {
    @EntityGraph(attributePaths = {"transactions"})
    List<Block> findAll();
}
