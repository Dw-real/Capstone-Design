import React, { useState } from 'react';
import Home from './HomeScreen';
import Map from './MapScreen';

function App() {
  const [page, setPage] = useState('home');

  const handlePageChange = (pageName) => {
    setPage(pageName);
  };

  return (
    <div className="App">
      <header>
        <h1>한성마켓</h1>
      </header>
      <nav>
        <ul>
          <li onClick={() => handlePageChange('home')}>홈</li>
          <li onClick={() => handlePageChange('map')}>지도</li>
        </ul>
      </nav>
      {page === 'home' && <Home />}
      {page === 'map' && <Map />}
    </div>
  );
}

export default App;
