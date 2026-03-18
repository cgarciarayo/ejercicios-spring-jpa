package com.cgarciarayo.ejerciciosspringjpa.controllers;

import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import com.cgarciarayo.ejerciciosspringjpa.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gestiono las peticiones HTTP relacionadas con la entidad Book.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    /**
     * Inyecto el repositorio de libros en el controlador.
     *
     * @param bookRepository repositorio de libros
     */
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Obtengo todos los libros disponibles.
     *
     * @return lista de libros
     */
    @GetMapping
    public List<Book> getAllBooks() {
        System.out.println("El usuario [admin] ha realizado la accion: consultar todos los libros");
        return bookRepository.findAll();
    }

    /**
     * Obtengo los libros publicados en un año concreto.
     *
     * @param year año de publicación
     * @return lista de libros publicados en el año indicado
     */
    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable Integer year) {
        System.out.println("El usuario [admin] ha realizado la accion: consultar libros del anio " + year);
        return bookRepository.findByPublicationYear(year);
    }

    /**
     * Obtengo un libro a partir de su ISBN.
     *
     * @param isbn isbn del libro
     * @return libro encontrado o null si no existe
     */
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        System.out.println("El usuario [admin] ha realizado la accion: consultar libro con ISBN " + isbn);
        return bookRepository.findByIsbn(isbn);
    }

    /**
     * Obtengo los libros de una editorial concreta.
     *
     * @param publisher nombre de la editorial
     * @return lista de libros de la editorial indicada
     */
    @GetMapping("/publisher/{publisher}")
    public List<Book> getBooksByPublisher(@PathVariable String publisher) {
        System.out.println("El usuario [admin] ha realizado la accion: consultar libros de la editorial " + publisher);
        return bookRepository.findByPublisherPublisherName(publisher);
    }

    /**
     * Obtengo los libros de una editorial concreta publicados en un año determinado.
     *
     * @param publisher nombre de la editorial
     * @param year año de publicación
     * @return lista de libros que cumplen ambas condiciones
     */
    @GetMapping("/publisher/{publisher}/year/{year}")
    public List<Book> getBooksByPublisherAndYear(
            @PathVariable String publisher,
            @PathVariable Integer year) {

        System.out.println("El usuario [admin] ha realizado la accion: consultar libros de la editorial " + publisher + " publicados en el anio " + year);
        return bookRepository.findByPublisherPublisherNameAndPublicationYear(publisher, year);
    }
}