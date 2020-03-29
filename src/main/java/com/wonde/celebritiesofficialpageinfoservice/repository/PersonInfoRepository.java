package com.wonde.celebritiesofficialpageinfoservice.repository;

import com.wonde.celebritiesofficialpageinfoservice.model.PersonsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonInfoRepository extends JpaRepository<PersonsInfo, Integer> {

    Optional<List<PersonsInfo>> findByFullName(String fullName);
    Optional <List<PersonsInfo>> findByMaritalStatus(String maritalStatus);
}
