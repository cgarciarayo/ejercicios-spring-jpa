package com.cgarciarayo.ejerciciosspringjpa.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represento los datos de entrada necesarios para crear un libro.
 */
public class BookRequestDto {

    /**
     * Almaceno el ISBN del libro.
     */
    @NotBlank(message = "El isbn es obligatorio.")
    @Size(min = 3, max = 20, message = "El isbn debe tener entre 3 y 20 caracteres.")
    private String isbn;

    /**
     * Almaceno el título del libro.
     */
    @NotBlank(message = "El titulo es obligatorio.")
    @Size(min = 3, max = 200, message = "El titulo debe tener entre 3 y 200 caracteres.")
    private String title;

    /**
     * Almaceno el año de publicación del libro.
     */
    @NotNull(message = "El anio de publicacion es obligatorio.")
    @Min(value = 1000, message = "El anio de publicacion debe ser mayor o igual que 1000.")
    private Integer publicationYear;

    /**
     * Almaceno el identificador del autor.
     */
    @NotNull(message = "El id del autor es obligatorio.")
    private Integer authorId;

    /**
     * Almaceno el identificador de la editorial.
     */
    @NotNull(message = "El id de la editorial es obligatorio.")
    private Integer publisherId;

    /**
     * Almaceno el identificador de la temática.
     */
    @NotNull(message = "El id de la tematica es obligatorio.")
    private Integer themeId;

    /**
     * Creo un constructor vacío.
     */
    public BookRequestDto() {
    }

    /**
     * Obtengo el isbn del libro.
     *
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establezco el isbn del libro.
     *
     * @param isbn isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtengo el título del libro.
     *
     * @return título del libro
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establezco el título del libro.
     *
     * @param title título del libro
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtengo el año de publicación del libro.
     *
     * @return año de publicación
     */
    public Integer getPublicationYear() {
        return publicationYear;
    }

    /**
     * Establezco el año de publicación del libro.
     *
     * @param publicationYear año de publicación
     */
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Obtengo el identificador del autor.
     *
     * @return identificador del autor
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * Establezco el identificador del autor.
     *
     * @param authorId identificador del autor
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * Obtengo el identificador de la editorial.
     *
     * @return identificador de la editorial
     */
    public Integer getPublisherId() {
        return publisherId;
    }

    /**
     * Establezco el identificador de la editorial.
     *
     * @param publisherId identificador de la editorial
     */
    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * Obtengo el identificador de la temática.
     *
     * @return identificador de la temática
     */
    public Integer getThemeId() {
        return themeId;
    }

    /**
     * Establezco el identificador de la temática.
     *
     * @param themeId identificador de la temática
     */
    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }
}