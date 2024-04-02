package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.model.Transport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {

    List<Transport> findAllByType(String type);

    List<Transport> findAllByComfort(int comfort);

    List<Transport> findAllByFirma(String firma);


}