# Proyecto Spring Boot + JPA – Persistencia de datos

## Introducción

En este proyecto he trabajado con Spring Boot, Hibernate y Spring Data JPA con el objetivo de aprender a gestionar la persistencia de datos en una aplicación Java.

Para ello, he conectado la aplicación con una base de datos MySQL/MariaDB (XAMPP) y he implementado diferentes ejercicios relacionados con la creación de entidades, repositorios y consultas.

---

## Ejercicio JPA 1 – Configuración del datasource

En este ejercicio he configurado la conexión entre la aplicación Spring Boot y la base de datos.

Para ello:

* He definido los parámetros de conexión en el fichero `application.properties`
* He configurado:

  * URL de conexión
  * Usuario y contraseña
  * Driver de MySQL
* He utilizado Hibernate como ORM
* He configurado JPA para gestionar automáticamente las tablas

Gracias a esta configuración, la aplicación puede conectarse correctamente a la base de datos y trabajar con ella.

---

## Ejercicio JPA 2 – Creación de entidades

En este ejercicio he creado las clases que representan las tablas de la base de datos.

He definido las siguientes entidades:

* Author
* Book
* Publisher
* Theme

Para cada una de ellas:

* He utilizado anotaciones de JPA como `@Entity` y `@Table`
* He definido las columnas con `@Column`
* He configurado las claves primarias con `@Id` y `@GeneratedValue`
* He establecido relaciones entre entidades con `@ManyToOne` y `@JoinColumn`

De esta forma, Hibernate puede mapear automáticamente las tablas de la base de datos con las clases Java.

---

## Ejercicio JPA 3 – Repositorios JPA

En este ejercicio he creado interfaces de tipo `JpaRepository` para cada entidad:

* AuthorRepository
* BookRepository
* PublisherRepository
* ThemeRepository

Gracias a esto, he obtenido automáticamente operaciones CRUD sin necesidad de implementarlas manualmente.

Además, he comprobado su funcionamiento utilizando un `CommandLineRunner`, mostrando por consola el número de registros de cada entidad.

---

## Ejercicio JPA 4 – Consulta con @Query

En este ejercicio he implementado mi primera consulta personalizada utilizando la anotación `@Query`.

El objetivo era obtener los libros publicados después de una fecha determinada.

Como en mi modelo de datos solo almaceno el año de publicación, he adaptado la consulta a:

* Obtener los libros con año de publicación mayor que 2001

He definido la query en el repositorio `BookRepository` utilizando JPQL.

---

## Ejercicio JPA 5 – Consulta por nombre de método

En este ejercicio he realizado la misma consulta anterior, pero sin utilizar `@Query`.

He utilizado la convención de nombres de Spring Data JPA:

```java
findByPublicationYearGreaterThan
```

Spring genera automáticamente la consulta a partir del nombre del método, lo que simplifica el desarrollo y reduce errores.

He comprobado que el resultado es el mismo que en el ejercicio anterior.

---

## Ejercicio JPA 6 – Consultas adicionales

En este ejercicio he implementado varias consultas sobre la entidad `Book`:

### 1. Libros publicados en un año concreto

```java
findByPublicationYear(Integer publicationYear)
```

### 2. Libro por ISBN

```java
findByIsbn(String isbn)
```

Se ha utilizado el valor literal del enunciado (`87919878`), aunque no existe en los datos cargados.

### 3. Libros de una editorial

```java
findByPublisherPublisherName(String publisherName)
```

### 4. Libros de una editorial en un año concreto

```java
findByPublisherPublisherNameAndPublicationYear(String publisherName, Integer publicationYear)
```

## Ejercicio opcional – Documentación JavaDoc

En este ejercicio he añadido comentarios JavaDoc en las clases, atributos y métodos del proyecto con el objetivo de documentar correctamente el código.

He utilizado el formato estándar de JavaDoc, incluyendo descripciones en primera persona y anotaciones como @param y @return en los métodos.

La documentación se ha generado utilizando Maven mediante el siguiente comando:

mvn javadoc:javadoc

El resultado se puede consultar en la siguiente ruta del proyecto:

target/site/apidocs/index.html

<img width="1864" height="885" alt="Captura de pantalla 2026-03-18 103112" src="https://github.com/user-attachments/assets/eb8b8108-44ad-4273-ac2d-7863289b9d72" />

---

