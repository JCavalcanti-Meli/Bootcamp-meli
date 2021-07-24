#2
insert into movies (title, rating, awards, release_date, length, genre_id) VALUES ('Batman vs Superman', 9.9, 10,'2019-07-04', 230, 5);

#3
select * from genres;
insert into genres (name, ranking) value ('Brasileiros', 13);

#4
select * from movies;
update movies set  genre_id = 13 where id=22;

#5
CREATE TEMPORARY TABLE tempMovies ENGINE=MEMORY 
as (select * from movies);

#Exercicio 6
CREATE TEMPORARY TABLE movies_copy AS (SELECT * FROM movies);

#Exercicio 7
DELETE FROM movies_copy
WHERE movies_copy.awards < 5;

SELECT * FROM movies_copy;

#Exercicio 8
SELECT DISTINCT g.* FROM genres g
INNER JOIN movies m ON g.id = m.genre_id;

#Exercicio 9
SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

SHOW INDEX FROM movies;

#Exercicio 12
CREATE INDEX movies_title_idx ON movies(title);

#Exercicio 13
SHOW INDEX FROM movies;