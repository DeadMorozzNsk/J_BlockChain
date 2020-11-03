package com.simplechain.webapp.backend.repos;

import com.simplechain.webapp.backend.models.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepo extends JpaRepository<Block, Long> {
}
