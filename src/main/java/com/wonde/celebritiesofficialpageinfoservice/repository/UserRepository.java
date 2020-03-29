package com.wonde.celebritiesofficialpageinfoservice.repository;

import com.wonde.celebritiesofficialpageinfoservice.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<AppUsers, Integer> {

    Optional<AppUsers> findByUserName(String user_name);
}
