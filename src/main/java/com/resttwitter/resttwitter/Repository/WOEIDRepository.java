package com.resttwitter.resttwitter.Repository;

import com.resttwitter.resttwitter.entities.WOEIDObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WOEIDRepository extends JpaRepository<WOEIDObject, String> {

//        @Query("SELECT n FROM woeidobject  n WHERE n.name = ?1")
//        WOEIDObject findIdByCity(String name);

    WOEIDObject findByNameIgnoreCaseContaining(String name);



}
