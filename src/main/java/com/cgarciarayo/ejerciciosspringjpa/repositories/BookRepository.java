package com.cgarciarayo.ejerciciosspringjpa.repositories;

import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestiono el acceso a datos de la entidad Book.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}