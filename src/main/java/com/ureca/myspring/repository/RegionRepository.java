package com.ureca.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ureca.myspring.dto.RegionDTO;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionDTO, Long> {

    @Query("SELECT DISTINCT r.zone FROM RegionDTO r")
    List<String> findDistinctZone();
    
    @Query("SELECT DISTINCT r.city FROM RegionDTO r WHERE r.zone = :zone")
    List<String> findDistinctCity(@Param("zone") String zone);

    Optional<RegionDTO> findById(Long id);
    
    List<RegionDTO> findByZone(String zone);

}
