SELECT client.name, DATEDIFF(month, start_date, finish_date) as month_count FROM client 
LEFT JOIN project ON client.id = project.client_id
WHERE client_id IN (
    SELECT client_id
    FROM project
    WHERE DATEDIFF(month, start_date, finish_date) IN (
        SELECT MAX(DATEDIFF(month, start_date, finish_date)) FROM project
        )
)
AND DATEDIFF(month, start_date, finish_date) IN (
    SELECT MAX(DATEDIFF(month, start_date, finish_date)) FROM project
)