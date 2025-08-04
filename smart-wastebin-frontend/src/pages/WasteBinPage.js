import React, { useEffect, useState } from 'react';
import { getAllWasteBins } from '../services/WasteBinService';

function WasteBinPage() {
  const [bins, setBins] = useState([]);

  useEffect(() => {
    getAllWasteBins().then(response => setBins(response.data));
  }, []);

  return (
    <div>
      <h2>Waste Bins</h2>
      <ul>
        {bins.map(bin => (
          <li key={bin.id}>{bin.location} - {bin.status}</li>
        ))}
      </ul>
    </div>
  );
}

export default WasteBinPage;
