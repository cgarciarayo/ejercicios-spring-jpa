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

    /**
     * Obtengo los libros cuyo año de publicación es mayor que el indicado
     * utilizando la convención de nombres de Spring Data JPA.
     *
     * @param publicationYear año de publicación de referencia
     * @return lista de libros publicados después del año indicado
     */
    List<Book> findByPublicationYearGreaterThan(Integer publicationYear);

    /**
     * Obtengo los libros publicados en un año concreto.
     *
     * @param publicationYear año de publicación a buscar
     * @return lista de libros publicados en el año indicado
     */
    List<Book> findByPublicationYear(Integer publicationYear);

    /**
     * Obtengo un libro a partir de su ISBN.
     *
     * @param isbn isbn del libro
     * @return libro encontrado o null si no existe
     */
    Book findByIsbn(String isbn);

    /**
     * Obtengo los libros de una editorial concreta.
     *
     * @param publisherName nombre de la editorial
     * @return lista de libros de la editorial indicada
     */
    List<Book> findByPublisherPublisherName(String publisherName);

    /**
     * Obtengo los libros de una editorial concreta publicados en un año determinado.
     *
     * @param publisherName nombre de la editorial
     * @param publicationYear año de publicación
     * @return lista de libros que cumplen ambas condiciones
     */
    List<Book> findByPublisherPublisherNameAndPublicationYear(String publisherName, Integer publicationYear);

}