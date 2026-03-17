package com.cgarciarayo.ejerciciosspringjpa.repositories;

import com.cgarciarayo.ejerciciosspringjpa.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestiono el acceso a datos de la entidad Author.
 * Heredo de JpaRepository para disponer de operaciones CRUD.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}