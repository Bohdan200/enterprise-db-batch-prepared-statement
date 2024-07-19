SELECT project_name as name, SUM(worker.salary) * DATEDIFF(month, start_date, finish_date) as price,
FROM project
LEFT JOIN project_worker ON project.client_id = project_worker.project_id
LEFT JOIN worker ON project_worker.worker_id = worker.id
GROUP BY project_name
ORDER BY price DESC