package com.cgarciarayo.ejerciciosspringjpa;

import com.cgarciarayo.ejerciciosspringjpa.entities.Book;
import com.cgarciarayo.ejerciciosspringjpa.repositories.AuthorRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.BookRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.PublisherRepository;
import com.cgarciarayo.ejerciciosspringjpa.repositories.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciosSpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjerciciosSpringJpaApplication.class, args);
    }

    /**
     * Compruebo que los repositorios JPA funcionan correctamente
     * ejecutando consultas básicas al arrancar la aplicación.
     */
    @Bean
    public CommandLineRunner testRepositories(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository,
            ThemeRepository themeRepository) {

        return args -> {

            System.out.println("Autores: " + authorRepository.findAll().size());
            System.out.println("Libros: " + bookRepository.findAll().size());
            System.out.println("Editoriales: " + publisherRepository.findAll().size());
            System.out.println("Tematicas: " + themeRepository.findAll().size());

            System.out.println("Libros publicados despues de 2001:");
            bookRepository.findBooksPublishedAfterYear(2001)
                    .forEach(book -> System.out.println(book.getTitle()));

            System.out.println("Metodo automatico JPA:");
            bookRepository.findByPublicationYearGreaterThan(2001)
                    .forEach(book -> System.out.println(book.getTitle()));

            System.out.println("Libros publicados en 2001:");
            bookRepository.findByPublicationYear(2001)
                    .forEach(book -> System.out.println(book.getTitle()));

            System.out.println("Libro con ISBN 87919878:");
            Book bookByIsbn = bookRepository.findByIsbn("87919878");
            if (bookByIsbn != null) {
                System.out.println(bookByIsbn.getTitle());
            } else {
                System.out.println("No se ha encontrado ningun libro con ese ISBN.");
            }

            System.out.println("Libros de la editorial RBA:");
            bookRepository.findByPublisherPublisherName("RBA")
                    .forEach(book -> System.out.println(book.getTitle()));

            System.out.println("Libros de la editorial PLANETA publicados en 1986:");
            bookRepository.findByPublisherPublisherNameAndPublicationYear("PLANETA", 1986)
                    .forEach(book -> System.out.println(book.getTitle()));
        };
    }
}