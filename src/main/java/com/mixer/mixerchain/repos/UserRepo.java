package com.mixer.mixerchain.repos;

import com.mixer.mixerchain.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

}
