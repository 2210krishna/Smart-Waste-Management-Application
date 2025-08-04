import React from 'react';
import UserPage from './pages/UserPage';
import WasteBinPage from './pages/WasteBinPage';
import RoutePage from './pages/RoutePage';

function App() {
  return (
    <div>
      <h1>Smart Wastebin Management</h1>
      <UserPage />
      <WasteBinPage />
      <RoutePage />
    </div>
  );
}

export default App;
