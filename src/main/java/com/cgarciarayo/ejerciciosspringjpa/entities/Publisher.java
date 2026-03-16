package com.cgarciarayo.ejerciciosspringjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represento la entidad Publisher de la aplicación.
 * Esta clase se corresponde con la tabla editoriales de la base de datos.
 */
@Entity
@Table(name = "editoriales")
public class Publisher {

    /**
     * Almaceno el identificador único de la editorial.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Integer idPublisher;

    /**
     * Almaceno el nombre comercial de la editorial.
     */
    @Column(name = "editorial", nullable = false, length = 120)
    private String publisherName;

    /**
     * Almaceno la razón social de la editorial.
     */
    @Column(name = "razon_social", nullable = false, length = 200)
    private String companyName;

    /**
     * Creo un constructor vacío obligatorio para JPA.
     */
    public Publisher() {
    }

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}