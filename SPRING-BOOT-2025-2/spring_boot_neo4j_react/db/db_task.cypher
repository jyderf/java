
//DROP DATABASE tareas;
//CREATE DATABASE tareas;
USE tareas

CREATE (usuario1:User {id: "1", name: "Juan"});
CREATE (usuario2:User {id: "2", name: "María"});
CREATE (usuario3:User {id: "3", name: "Carlos"});

CREATE (tarea1:Task {id: "101", title: "Pagar facturas", completed: false});
CREATE (tarea2:Task {id: "102", title: "Enviar informe", completed: true});
CREATE (tarea3:Task {id: "103", title: "Llamar al cliente", completed: false});

CREATE (usuario1)-[r1:ASIGNADO_A]->(tarea1)
CREATE (usuario2)-[r2:ASIGNADO_A]->(tarea2)
CREATE (usuario3)-[r3:ASIGNADO_A]->(tarea3)

RETURN *;