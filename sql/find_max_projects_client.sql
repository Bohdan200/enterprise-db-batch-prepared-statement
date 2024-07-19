SELECT client.name, COUNT(*) as project_count FROM project
LEFT JOIN client ON client_id = client.id
WHERE client_id IN (
 SELECT client_id
    FROM project
    GROUP BY client_id
    HAVING COUNT(client_id) IN (
        SELECT count(client_id)
        FROM project
        GROUP BY client_id
        ORDER BY count(client_id) DESC
        LIMIT 1
    )
)
GROUP BY client_id

