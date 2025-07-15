CREATE TABLE topicos (
    id BIGSERIAL PRIMARY KEY,

    titulo VARCHAR(100) NOT NULL,

    mensaje VARCHAR(150) NOT NULL,

    fecha_creacion DATE NOT NULL,

    status VARCHAR(100) NOT NULL,

    autor VARCHAR(100) NOT NULL,

    curso VARCHAR(100) ,

    respuesta VARCHAR(200)
);