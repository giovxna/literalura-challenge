## LiterAlura

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
<img src="https://github.com/giovxna/literalura-challenge/blob/main/badge%20literalura.png" width="150px" align="right">

LiterAlura is a book catalog application developed using Java, Spring Boot, Hibernate, and an H2 database. It integrates with the Gutendex API to fetch book information based on user input.

## Features

- Search by Title: Search for books by their title using the Gutendex API.
- List Authors: Display a list of authors along with their details.
- Multi-language Support: Supports books in multiple languages.

## Dependencies
- Java 11 or higher
- Maven

## Setup
Clone the repository:

```
git clone https://github.com/giovxna/literalura-challenge.git
cd literalura
```

Build the project:

```
mvn clean package
```

Run the application:

```
java -jar target/literalura-challenge-1.0.jar
```

## Usage
It allows users to search for books by title, list all books, list authors, and perform various other functionalities related to book management.

### Interaction example

```
Livro encontrado e salvo no banco de dados:
Título: Emma
Autor: Austen, Jane
Idioma: en
```
