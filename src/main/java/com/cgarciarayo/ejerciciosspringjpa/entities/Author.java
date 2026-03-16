package com.cgarciarayo.ejerciciosspringjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Aquí represento la entidad Author de la aplicación.
 * Esta clase se corresponde con la tabla autores de la base de datos.
 */
@Entity
@Table(name = "autores")
public class Author {

    /**
     * Almaceno el identificador único del autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Integer idAuthor;

    /**
     * Almaceno el nombre del autor.
     */
    @Column(name = "nombre", nullable = false, length = 60)
    private String name;

    /**
     * Almaceno los apellidos del autor.
     */
    @Column(name = "apellidos", nullable = false, length = 120)
    private String surnames;

    /**
     * Almaceno la fecha de nacimiento del autor.
     */
    @Column(name = "fecha_nacimiento")
    private java.sql.Date birthDate;

    /**
     * Ahora creo un constructor vacío obligatorio para JPA.
     */
    public Author() {
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }
}