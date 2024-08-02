ALTER TABLE project
ADD CONSTRAINT project_name_check
CHECK (LENGTH(project_name) >= 2 AND LENGTH(project_name) <= 100);

ALTER TABLE project
ADD CONSTRAINT project_start_date_check
CHECK (start_date > '1990-12-31');

ALTER TABLE project
ADD CONSTRAINT project_finish_date_check
CHECK (finish_date > '1990-12-31');