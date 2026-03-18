package com.cgarciarayo.ejerciciosspringjpa.controllers;

import com.cgarciarayo.ejerciciosspringjpa.dtos.BookRequestDto;
import com.cgarciarayo.ejerciciosspringjpa.entities.Author;
import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import com.cgarciarayo.ejerciciosspringjpa.entities.Publisher;
import com.cgarciarayo.ejerciciosspringjpa.entities.Theme;
import com.cgarciarayo.ejerciciosspringjpa.repositories.AuthorRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.BookRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.PublisherRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.ThemeRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Gestiono las peticiones HTTP relacionadas con la entidad Book.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ThemeRepository themeRepository;

    /**
     * Inyecto los repositorios necesarios en el controlador.
     *
     * @param bookRepository repositorio de libros
     * @param authorRepository repositorio de autores
     * @param publisherRepository repositorio de editoriales
     * @param themeRepository repositorio de tematicas
     */
    public BookController(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            PublisherRepository publisherRepository,
            ThemeRepository themeRepository) {

        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.themeRepository = themeRepository;
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
     * Obtengo los libros publicados en un anio concreto.
     *
     * @param year anio de publicacion
     * @return lista de libros publicados en el anio indicado
     */
    @GetMapping("/year/{year}")
    public List<Book> getBooksByYear(@PathVariable Integer year) {
        System.out.println("El usuario [admin] ha realizado la accion: consultar libros del anio " + year);
        return bookRepository.findByPublicationYear(year);
    }

    /**
     * Obtengo un libro a partir de su isbn.
     *
     * @param isbn isbn del libro
     * @return libro encontrado o null si no existe
     */
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        System.out.println("El usuario [admin] ha realizado la accion: consultar libro con isbn " + isbn);
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

        System.out.println("El usuario [admin] ha realizado la accion: consultar libros de la editorial "
                + publisher + " publicados en el anio " + year);

        return bookRepository.findByPublisherPublisherNameAndPublicationYear(publisher, year);
    }

    /**
     * Creo un nuevo libro validando los datos recibidos.
     *
     * @param bookRequestDto datos del libro a crear
     * @return libro guardado
     */
    @PostMapping
    public Book createBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
        System.out.println("El usuario [admin] ha realizado la accion: crear un nuevo libro");

        Author author = authorRepository.findById(bookRequestDto.getAuthorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado."));

        Publisher publisher = publisherRepository.findById(bookRequestDto.getPublisherId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrada."));

        Theme theme = themeRepository.findById(bookRequestDto.getThemeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tematica no encontrada."));

        Book book = new Book();
        book.setIsbn(bookRequestDto.getIsbn());
        book.setTitle(bookRequestDto.getTitle());
        book.setPublicationYear(bookRequestDto.getPublicationYear());
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setTheme(theme);

        return bookRepository.save(book);
    }
}