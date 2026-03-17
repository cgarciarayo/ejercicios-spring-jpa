package com.cgarciarayo.ejerciciosspringjpa.repositories;

import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Gestiono el acceso a datos de la entidad Book.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Obtengo los libros cuyo año de publicación es mayor que el año indicado.
     *
     * @param publicationYear año de publicación de referencia
     * @return lista de libros publicados después del año indicado
     */
    @Query("SELECT book FROM Book book WHERE book.publicationYear > ?1")
    List<Book> findBooksPublishedAfterYear(Integer publicationYear);

}