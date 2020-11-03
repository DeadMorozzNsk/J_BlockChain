package com.mixer.webapp.backend.repos;

import com.mixer.webapp.backend.models.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepo extends JpaRepository<WebUser, Long> {

}
