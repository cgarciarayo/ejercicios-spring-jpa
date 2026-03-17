package com.cgarciarayo.ejerciciosspringjpa.repositories;

import com.cgarciarayo.ejerciciosspringjpa.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestiono el acceso a datos de la entidad Publisher.
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}