drop table if exists coches;

CREATE TABLE COCHES
(
    -- 1. Secuencia implícita con BIGINT (Long en Java)
    ID               BIGINT GENERATED ALWAYS AS IDENTITY,
    MARCA            VARCHAR(100),
    MODELO           VARCHAR(100),
    ANIO_LANZAMIENTO VARCHAR(4),
    CABALLOS         NUMERIC(4),
    -- 2. Campo de URL para validar
    PAGINA_WEB       VARCHAR(300),

    CONSTRAINT "PK_COCHES"             PRIMARY KEY (ID),
    CONSTRAINT "NN_COCHES_MARCA"       CHECK(MARCA IS NOT NULL),
    CONSTRAINT "NN_COCHES_MODELO"      CHECK(MODELO IS NOT NULL),
    CONSTRAINT "CH_COCHES_CABALLOS"    CHECK(CABALLOS > 0)
);

-- INSERTS PARA COCHES
-- Fíjate que NO le pasamos el ID, la BD lo genera solo: 1, 2, 3...

INSERT INTO COCHES(MARCA, MODELO, ANIO_LANZAMIENTO, CABALLOS, PAGINA_WEB)
VALUES('Porsche', '911 Carrera', '1963', 385, 'https://www.porsche.com/spain/models/911/');

INSERT INTO COCHES(MARCA, MODELO, ANIO_LANZAMIENTO, CABALLOS, PAGINA_WEB)
VALUES('Ferrari', 'F40', '1987', 478, 'https://www.ferrari.com/es-ES/auto/f40');

INSERT INTO COCHES(MARCA, MODELO, ANIO_LANZAMIENTO, CABALLOS, PAGINA_WEB)
VALUES('Ford', 'Mustang GT', '1964', 450, 'https://www.ford.es/turismos/mustang');

COMMIT;
