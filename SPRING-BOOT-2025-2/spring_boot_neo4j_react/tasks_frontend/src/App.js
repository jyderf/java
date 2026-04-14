import { useEffect, useState } from "react";

export default function App() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/users")
      .then((res) => {
        if (!res.ok) {
          throw new Error("Error en la petición");
        }
        return res.json();
      })
      .then((data) => {
        console.log("Datos recibidos:", data);
        setUsers(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error:", err);
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <h2>Cargando usuarios...</h2>;
  if (error) return <h2>Error: {error}</h2>;

  return (
    <div style={{ padding: "20px" }}>
      <h1>Lista de Usuarios</h1>

      {users.length === 0 ? (
        <p>No hay usuarios.</p>
      ) : (
        <ul>
          {users.map((u) => (
            <li
              key={String(u.id)}
              style={{
                marginBottom: "10px",
                padding: "10px",
                border: "1px solid #ccc",
                borderRadius: "8px",
              }}
            >
              <strong>ID:</strong> {u.id} <br />
              <strong>Nombre:</strong> {u.name}
              <br />
              <strong>Tareas:</strong>
              {u.tasks && u.tasks.length > 0 ? (
                <ul>
                  {u.tasks.map((t) => (
                    <li key={String(t.id)}>
                      {t.title} — {t.completed ? "✔" : "❌"}
                    </li>
                  ))}
                </ul>
              ) : (
                <p>Sin tareas.</p>
              )}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
