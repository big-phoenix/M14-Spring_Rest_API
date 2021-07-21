/*DROP TABLE IF EXISTS tienda;
DROP TABLE IF EXISTS cuadro;
*/

CREATE TABLE tienda 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  capacidad int NOT NULL
);

CREATE TABLE cuadro 
(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  autor VARCHAR(250),
  precio FLOAT NOT NULL,
  tienda_id INT,
  FOREIGN KEY(tienda_id) REFERENCES tienda(id)
);