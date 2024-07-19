CREATE TABLE IF NOT EXISTS worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    birthday DATE NOT NULL CHECK (birthday > '1900-12-31'),
    level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT NOT NULL CHECK (salary >= 100 AND salary < 100000),
    CONSTRAINT name_check CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
)


CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000)
)


CREATE TABLE IF NOT EXISTS project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    project_name VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL CHECK (start_date > '1990-12-31'),
    finish_date DATE NOT NULL CHECK (finish_date > '1990-12-31'),
    CONSTRAINT project_name_check CHECK (LENGTH(project_name) >= 2 AND LENGTH(project_name) <= 100),
    CONSTRAINT project_client_id_fk FOREIGN KEY (client_id)
    REFERENCES client(id)
)


CREATE TABLE IF NOT EXISTS project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    CONSTRAINT project_worker_pk PRIMARY KEY (project_id, worker_id),
    CONSTRAINT project_worker_project_id_fk FOREIGN KEY (project_id)
    REFERENCES project(id),
    CONSTRAINT project_worker_worker_id_fk FOREIGN KEY (worker_id)
    REFERENCES worker(id)
)