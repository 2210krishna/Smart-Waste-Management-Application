import React, { useEffect, useState } from 'react';
import { getAllUsers } from '../services/UserService';

function UserPage() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getAllUsers().then(response => setUsers(response.data));
  }, []);

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map(u => (
          <li key={u.id}>{u.name} - {u.email}</li>
        ))}
      </ul>
    </div>
  );
}

export default UserPage;
