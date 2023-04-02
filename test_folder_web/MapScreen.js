import React, { useState } from 'react';
import GoogleMapReact from '@react-google-maps/api';

function MapScreen() {
  const [searchQuery, setSearchQuery] = useState('');
  const [markers, setMarkers] = useState([
    { id: 1, lat: 37.556799, lng: 126.926065, title: '사용자1', product: '사과' },
    { id: 2, lat: 37.551598, lng: 126.936065, title: '사용자2', product: '바나나' },
    { id: 3, lat: 37.556799, lng: 126.946065, title: '사용자3', product: '딸기' },
  ]);

  const handleSearch = () => {
    // 검색 기능 구현
  };

  const handleApiLoaded = (map, maps) => {
    markers.forEach((marker) => {
      const newMarker = new maps.Marker({
        position: { lat: marker.lat, lng: marker.lng },
        map,
        title: marker.title,
      });

      newMarker.addListener('click', () => {
        // 마커 클릭 시 이벤트 처리
      });
    });
  };

  return (
    <div>
      <div className="header">
        <h1>한성마켓</h1>
      </div>
      <div className="menu">
        <a href="/">Home</a>
        <a href="/map">Map</a>
      </div>
      <div className="search-bar">
        <input
          type="text"
          placeholder="물건 종류를 입력하세요"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        <button onClick={handleSearch}>검색</button>
      </div>
      <div className="map-container">
        <GoogleMapReact
          bootstrapURLKeys={{ key: process.env.REACT_APP_GOOGLE_MAPS_API_KEY }}
          defaultCenter={{ lat: 37.556799, lng: 126.926065 }}
          defaultZoom={14}
          yesIWantToUseGoogleMapApiInternals
          onGoogleApiLoaded={({ map, maps }) => handleApiLoaded(map, maps)}
        >
          {markers.map((marker) => (
            <div
              key={marker.id}
              lat={marker.lat}
              lng={marker.lng}
              style={{
                backgroundColor: '#fff',
                borderRadius: '50%',
                padding: '5px',
                border: '1px solid #999',
                position: 'absolute',
                transform: 'translate(-50%, -50%)',
              }}
            >
              {marker.product}
            </div>
          ))}
        </GoogleMapReact>
      </div>
    </div>
  );
}

export default MapScreen;
