DROP DATABASE IF EXISTS libraryDataBase;
CREATE DATABASE libraryDataBase;
USE libraryDataBase;

CREATE TABLE authors(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE publishers(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE books(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL UNIQUE,
    author_id INTEGER NOT NULL,
    publishers_id INTEGER NOT NULL,
    year_published YEAR NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    FOREIGN KEY (publishers_id) REFERENCES publishers(id)
);

CREATE TABLE users(
    id INTEGER AUTO_INCREMENT,
    name CHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE loans(
    id_loan INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    date DATE,
    PRIMARY KEY(id_loan),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

INSERT INTO authors(name) VALUES ("Tolstoi");
INSERT INTO authors(name) VALUES ("Dostoiévski");
INSERT INTO authors(name) VALUES ("Jane Austen");

INSERT INTO users(name) VALUES ("Axel");
INSERT INTO users(name) VALUES ("Filipe");
INSERT INTO users(name) VALUES ("Anderson");
INSERT INTO users(name) VALUES ("Cristina");

INSERT INTO publishers(name) VALUES ("Presença");
INSERT INTO publishers(name) VALUES ("Porto Editora");
INSERT INTO publishers(name) VALUES ("Alma Classics");

INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("War and Peace", 1, 1, 1950);
INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("Anna Karenina", 1, 1, 2020);
INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("The Death of", 1, 1, 1960);
INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("Crime and Pu", 2, 2, 1901);
INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("The Brother", 2, 1, 1954);
INSERT INTO books(name, author_id, publishers_id, year_published) VALUES ("Pride and ", 3, 3, 1980);

INSERT INTO loans(user_id, book_id, date) VALUES (1, 2, "2023-02-13");
INSERT INTO loans(user_id, book_id, date) VALUES (2, 1, "2024-02-10");
INSERT INTO loans(user_id, book_id, date) VALUES (1, 3, "2023-04-03");
INSERT INTO loans(user_id, book_id, date) VALUES (3, 3, "2023-05-25");
INSERT INTO loans(user_id, book_id, date) VALUES (2, 1, "2023-08-30");
INSERT INTO loans(user_id, book_id, date) VALUES (3, 1, "2024-02-13");
INSERT INTO loans(user_id, book_id, date) VALUES (1, 2, "2023-09-29");
INSERT INTO loans(user_id, book_id, date) VALUES (2, 2, "2024-04-25");
INSERT INTO loans(user_id, book_id, date) VALUES (3, 1, "2024-01-13");
