package com.cgarciarayo.ejerciciosspringjpa.repositories;

import com.cgarciarayo.ejerciciosspringjpa.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestiono el acceso a datos de la entidad Theme.
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}