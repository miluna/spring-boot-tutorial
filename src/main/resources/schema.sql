DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE USUARIOS(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(250), email VARCHAR(250) NOT NULL, birth_date VARCHAR(12) NOT NULL);