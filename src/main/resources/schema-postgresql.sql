CREATE TABLE IF NOT EXISTS filmes(
    /*serial é autoincremento*/
    id serial PRIMARY KEY, 
    titulo VARCHAR(50),
    genero VARCHAR(11),
    ano year,
    diretor VARCHAR(40)
    );