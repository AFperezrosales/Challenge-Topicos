CREATE TABLE users_entity(
    id_user BIGSERIAL PRIMARY KEY,

    nombre VARCHAR(50) NOT NULL,

    email VARCHAR(50) NOT NULL UNIQUE,

    contrasena VARCHAR(100) NOT NULL
);


CREATE TABLE curso(
    id_curso BIGSERIAL PRIMARY KEY,

    nombre VARCHAR(100) NOT NULL,

    categoria VARCHAR(50) NOT NULL
);