package com.cgarciarayo.ejerciciosspringjpa.services;

import com.cgarciarayo.ejerciciosspringjpa.dtos.BookRequestDto;
import com.cgarciarayo.ejerciciosspringjpa.entities.Author;
import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import com.cgarciarayo.ejerciciosspringjpa.entities.Publisher;
import com.cgarciarayo.ejerciciosspringjpa.entities.Theme;
import com.cgarciarayo.ejerciciosspringjpa.repositories.AuthorRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.BookRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.PublisherRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.ThemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**Gestiono la logica de negocio relacionada con los libros.
 */
@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ThemeRepository themeRepository;

    /**
     * Inyecto los repositorios necesarios para trabajar con libros.
     */
    public BookService(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            PublisherRepository publisherRepository,
            ThemeRepository themeRepository) {

        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.themeRepository = themeRepository;
    }

    public List<Book> getAllBooks() {
        log.info("El usuario [admin] ha realizado la accion: consultar todos los libros");
        return bookRepository.findAll();
    }

    public List<Book> getBooksByYear(Integer year) {
        log.info("El usuario [admin] ha realizado la accion: consultar libros del anio {}", year);
        return bookRepository.findByPublicationYear(year);
    }

    public Book getBookByIsbn(String isbn) {
        log.info("El usuario [admin] ha realizado la accion: consultar libro con isbn {}", isbn);

        Book book = bookRepository.findByIsbn(isbn);

        if (book == null) {
            log.error("Libro no encontrado con isbn {}", isbn);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado.");
        }

        return book;
    }

    public List<Book> getBooksByPublisher(String publisher) {
        log.info("El usuario [admin] ha realizado la accion: consultar libros de la editorial {}", publisher);
        return bookRepository.findByPublisherPublisherName(publisher);
    }

    public List<Book> getBooksByPublisherAndYear(String publisher, Integer year) {
        log.info("El usuario [admin] ha realizado la accion: consultar libros de la editorial {} publicados en el anio {}", publisher, year);
        return bookRepository.findByPublisherPublisherNameAndPublicationYear(publisher, year);
    }

    public Book createBook(BookRequestDto bookRequestDto) {
        log.info("El usuario [admin] ha realizado la accion: crear un nuevo libro");

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