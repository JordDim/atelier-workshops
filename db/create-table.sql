CREATE TABLE workshop (
                          name VARCHAR(50) NOT NULL
);

-- Comentario para la tabla
COMMENT ON TABLE workshop IS 'Table containing the names of different workshops.';

-- Comentario para la columna
COMMENT ON COLUMN workshop.name IS 'Name of the workshop (maximum 50 characters).';

-- Crear índice para mejorar búsquedas por nombre
CREATE INDEX idx_workshop_name ON workshop(name);
