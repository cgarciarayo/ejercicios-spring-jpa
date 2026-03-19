package com.cgarciarayo.ejerciciosspringjpa.controllers;

import com.cgarciarayo.ejerciciosspringjpa.dtos.BookRequestDto;
import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import com.cgarciarayo.ejerciciosspringjpa.services.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Gestiono las peticiones HTTP relacionadas con la entidad Book.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    /**
     * Inyecto el servicio de libros en el controlador.
     *
     * @param bookService servicio de libros
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Obtengo todos los libros disponibles.
     *
     * @return lista de libros
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Obtengo los libros publicados en un anio concreto.
     *
     * @param year anio de publicacion
     * @return lista de libros publicados en el anio indicado
     */
    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable Integer year) {
        return bookService.getBooksByYear(year);
    }

    /**
     * Obtengo un libro a partir de su isbn.
     *
     * @param isbn isbn del libro
     * @return libro encontrado
     */
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    /**
     * Obtengo los libros de una editorial concreta.
     *
     * @param publisher nombre de la editorial
     * @return lista de libros de la editorial indicada
     */
    @GetMapping("/publisher/{publisher}")
    public List<Book> getBooksByPublisher(@PathVariable String publisher) {
        return bookService.getBooksByPublisher(publisher);
    }

    /**
     * Obtengo los libros de una editorial concreta publicados en un anio determinado.
     *
     * @param publisher nombre de la editorial
     * @param year anio de publicacion
     * @return lista de libros que cumplen ambas condiciones
     */
    @GetMapping("/publisher/{publisher}/year/{year}")
    public List<Book> getBooksByPublisherAndYear(
            @PathVariable String publisher,
            @PathVariable Integer year) {

        return bookService.getBooksByPublisherAndYear(publisher, year);
    }

    /**
     * Creo un nuevo libro validando los datos recibidos.
     *
     * @param bookRequestDto datos del libro a crear
     * @return libro guardado
     */
    @PostMapping
    public Book createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }
}