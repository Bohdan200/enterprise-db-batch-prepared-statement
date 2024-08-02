ALTER TABLE worker
DROP COLUMN level;

ALTER TABLE worker
ADD COLUMN level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL;