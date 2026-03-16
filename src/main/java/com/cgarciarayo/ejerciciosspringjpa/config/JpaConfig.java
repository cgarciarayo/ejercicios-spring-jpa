package com.cgarciarayo.ejerciciosspringjpa.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Configuro el gestor de transacciones de la aplicación.
 * Esto permite que las operaciones sobre la base de datos
 * se ejecuten de forma consistente y segura.
 */
@Configuration
public class JpaConfig {

    /**
     * Defino el transaction manager que utilizará Spring
     * para gestionar las transacciones con JPA.
     *
     * @param entityManagerFactory fábrica de EntityManager creada por Spring
     * @return gestor de transacciones JPA
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
