
ALTER TABLE topicos
ADD COLUMN autor_id BIGINT;

UPDATE topicos
SET autor_id = 1
WHERE autor_id IS NULL;

ALTER TABLE topicos
ALTER COLUMN autor_id SET NOT NULL;

ALTER TABLE topicos
ADD CONSTRAINT fk_autor
FOREIGN KEY (autor_id) REFERENCES users_entity(id_user)