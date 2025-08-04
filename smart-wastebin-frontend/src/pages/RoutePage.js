import React, { useEffect, useState } from 'react';
import { getAllRoutes } from '../services/RouteService';

function RoutePage() {
  const [routes, setRoutes] = useState([]);

  useEffect(() => {
    getAllRoutes().then(response => setRoutes(response.data));
  }, []);

  return (
    <div>
      <h2>Routes</h2>
      <ul>
        {routes.map(route => (
          <li key={route.id}>{route.name} - {route.distance} km</li>
        ))}
      </ul>
    </div>
  );
}

export default RoutePage;
