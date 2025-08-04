package com.example.demo.repositories;

import com.example.demo.entities.WasteBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteBinRepository extends JpaRepository<WasteBin, Long> {

    @Query("SELECT wb FROM WasteBin wb WHERE wb.location LIKE %:location%")
    List<WasteBin> searchWasteBinsByLocation(@Param("location") String location);
    List<WasteBin>findAllByUserId(Long userId);

}