package com.cgarciarayo.ejerciciosspringjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represento la entidad Theme de la aplicación.
 * Esta clase se corresponde con la tabla tematicas de la base de datos.
 */
@Entity
@Table(name = "tematicas")
public class Theme {

    /**
     * Almaceno el identificador único de la temática.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tematica")
    private Integer idTheme;

    /**
     * Almaceno la categoría de la temática.
     */
    @Column(name = "categoria", nullable = false, length = 80)
    private String category;

    /**
     * Creo un constructor vacío obligatorio para JPA.
     */
    public Theme() {
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}