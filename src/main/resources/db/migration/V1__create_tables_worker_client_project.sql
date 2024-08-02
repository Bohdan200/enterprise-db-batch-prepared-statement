CREATE TABLE IF NOT EXISTS worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    birthday DATE NOT NULL CHECK (birthday > '1900-12-31'),
    level VARCHAR(100) NOT NULL,
    salary INT NOT NULL CHECK (salary >= 100 AND salary < 100000),
    CONSTRAINT name_check CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
);

CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000)
);

CREATE TABLE IF NOT EXISTS project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    project_name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    finish_date DATE NOT NULL,
    CONSTRAINT project_client_id_fk FOREIGN KEY (client_id)
    REFERENCES client(id)
);