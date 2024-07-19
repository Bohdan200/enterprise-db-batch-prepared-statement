INSERT INTO worker (name, birthday, level, salary) VALUES 
('John', '1988-05-12', 'Trainee', 800), 
('Bill', '1984-06-07', 'Junior', 1200),
('Geremy', '1995-02-21', 'Junior', 1500),
('Linda', '1988-05-20', 'Middle', 2000),
('Viki', '1991-07-08', 'Middle', 2500),
('Kast', '2000-01-27', 'Middle', 3000),
('Liza', '1992-10-15', 'Middle', 4000),
('Met', '2002-08-17', 'Middle', 4500),
('Steve', '1998-11-25', 'Senior', 5200),
('Sympthon', '1992-03-15', 'Senior', 8000),
('Spenser', '1987-01-26', 'Senior', 8000),
('Derik', '2002-08-17', 'Junior', 1600),
('Jack', '1984-06-07', 'Senior', 7600)


INSERT INTO client (name) VALUES 
('Bill Geitz'),
('William Lokfood'), 
('Rob Maknanaman'), 
('Kristi Smith'), 
('Bob Lampard')


INSERT INTO project (client_id, project_name, start_date, finish_date) VALUES 
(2, 'Project A', '2024-02-12', '2024-05-17'),
(1, 'Project B', '2023-05-24', '2027-12-08'),
(3, 'Project C', '2020-04-03', '2024-11-10'),
(5, 'Project D', '2021-10-08', '2024-06-12'),
(4, 'Project E', '2022-07-18', '2024-10-28'),
(3, 'Project F', '2023-12-20', '2025-07-14'),
(3, 'Project G', '2024-04-19', '2024-08-23'),
(1, 'Project H', '2022-03-11', '2024-06-19'),
(2, 'Project I', '2023-09-03', '2025-01-30'),
(4, 'Project J', '2023-10-20', '2024-11-12'),
(4, 'Project K', '2021-11-07', '2023-05-22')


INSERT INTO project_worker (project_id, worker_id) VALUES 
(1, 5),
(2, 6),
(3, 7),
(4, 8),
(5, 9),
(6, 10),
(7, 9),
(7, 4),
(6, 6),
(11, 13),
(10, 12),
(8, 9),
(9, 7),
(3, 5),
(1, 10),
(7, 10),
(6, 9),
(7, 11),
(6, 4),
(10, 10)
