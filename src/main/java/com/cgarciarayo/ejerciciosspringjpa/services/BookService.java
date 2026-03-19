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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Gestiono la logica de negocio relacionada con los libros.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ThemeRepository themeRepository;

    /**
     * Inyecto los repositorios necesarios para trabajar con libros.
     *
     * @param bookRepository repositorio de libros
     * @param authorRepository repositorio de autores
     * @param publisherRepository repositorio de editoriales
     * @param themeRepository repositorio de tematicas
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

    /**
     * Obtengo todos los libros.
     *
     * @return lista de libros
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Obtengo los libros publicados en un anio concreto.
     *
     * @param year anio de publicacion
     * @return lista de libros publicados en ese anio
     */
    public List<Book> getBooksByYear(Integer year) {
        return bookRepository.findByPublicationYear(year);
    }

    /**
     * Obtengo un libro a partir de su isbn.
     *
     * @param isbn isbn del libro
     * @return libro encontrado o null si no existe
     */
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    /**
     * Obtengo los libros de una editorial concreta.
     *
     * @param publisher nombre de la editorial
     * @return lista de libros de la editorial indicada
     */
    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisherPublisherName(publisher);
    }

    /**
     * Obtengo los libros de una editorial concreta publicados en un anio determinado.
     *
     * @param publisher nombre de la editorial
     * @param year anio de publicacion
     * @return lista de libros que cumplen ambas condiciones
     */
    public List<Book> getBooksByPublisherAndYear(String publisher, Integer year) {
        return bookRepository.findByPublisherPublisherNameAndPublicationYear(publisher, year);
    }

    /**
     * Creo un nuevo libro a partir de los datos recibidos.
     *
     * @param bookRequestDto datos del libro a crear
     * @return libro guardado
     */
    public Book createBook(BookRequestDto bookRequestDto) {
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