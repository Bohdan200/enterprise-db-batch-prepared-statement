CREATE TABLE IF NOT EXISTS project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    CONSTRAINT project_worker_pk PRIMARY KEY (project_id, worker_id),
    CONSTRAINT project_worker_project_id_fk FOREIGN KEY (project_id)
    REFERENCES project(id),
    CONSTRAINT project_worker_worker_id_fk FOREIGN KEY (worker_id)
    REFERENCES worker(id)
);