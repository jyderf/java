import React, { useEffect, useState } from "react";
import API from "../api/api";

const UserList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await API.get("http://localhost:8080/users"); // ruta de tu backend
      setUsers(response.data);
    } catch (error) {
      console.error("Error fetching users:", error);
    }
  };

  return (
    <div>
      <h2>Usuarios y sus Tareas</h2>
      {users.length === 0 && <p>Cargando usuarios...</p>}
      {users.map((user) => (
        <div key={user.id} style={{ border: "1px solid gray", margin: "10px", padding: "10px" }}>
          <h3>{user.name}</h3>
          {user.tasks && user.tasks.length > 0 ? (
            <ul>
              {user.tasks.map((task) => (
                <li key={task.id}>
                  {task.title} - {task.priority} - {task.done ? "✔️" : "❌"}
                </li>
              ))}
            </ul>
          ) : (
            <p>No tiene tareas asignadas</p>
          )}
        </div>
      ))}
    </div>
  );
};

export default UserList;
