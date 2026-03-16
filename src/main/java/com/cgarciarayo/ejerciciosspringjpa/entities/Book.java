package com.cgarciarayo.ejerciciosspringjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represento la entidad Book de la aplicación.
 * Esta clase se corresponde con la tabla libros de la base de datos.
 */
@Entity
@Table(name = "libros")
public class Book {

    /**
     * Almaceno el identificador único del libro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idBook;

    /**
     * Almaceno el ISBN del libro.
     */
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    /**
     * Almaceno el título del libro.
     */
    @Column(name = "titulo", nullable = false, length = 200)
    private String title;

    /**
     * Almaceno el año de publicación del libro.
     */
    @Column(name = "anio_publicacion", nullable = false)
    private Integer publicationYear;

    /**
     * Almaceno la referencia al autor del libro.
     */
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Author author;

    /**
     * Almaceno la referencia a la editorial del libro.
     */
    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = false)
    private Publisher publisher;

    /**
     * Almaceno la referencia a la temática del libro.
     */
    @ManyToOne
    @JoinColumn(name = "id_tematica", nullable = false)
    private Theme theme;

    /**
     * Creo un constructor vacío obligatorio para JPA.
     */
    public Book() {
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}