package com.simplechain.webapp.backend.repos;

import com.simplechain.webapp.backend.models.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepo extends JpaRepository<WebUser, Long> {

}
