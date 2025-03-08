-- Letra A: Seleciona os vendedores que não realizaram vendas para o cliente Samsonic
SELECT DISTINCT s.Name
FROM Salesperson s
WHERE s.ID NOT IN (
    SELECT o.salesperson_id
    FROM Orders o
             JOIN Customer c ON o.customer_id = c.ID
    WHERE c.Name = 'Samsonic'
);

-- Letra B: Atualiza os nomes dos vendedores que fizeram 2 ou mais vendas e concatenando um * no final do nome
UPDATE Salesperson
SET Name = CONCAT(Name, '*')
WHERE ID IN (
    SELECT salesperson_id
    FROM Orders
    GROUP BY salesperson_id
    HAVING COUNT(*) >= 2
);

-- Letra C: Deleta os vendedores que realizaram vendas na cidade de Jackson
DELETE FROM Salesperson
WHERE ID IN (
    SELECT DISTINCT o.salesperson_id
    FROM Orders o
             JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);

-- Letra D: Retorna o nome de cada vendedor e o total de vendas
SELECT s.Name, COALESCE(SUM(o.Amount), 0) AS TotalSales
FROM Salesperson s
         LEFT JOIN Orders o ON s.ID = o.salesperson_id
GROUP BY s.Name;
