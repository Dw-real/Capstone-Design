import React from 'react';

function HomeScreen() {
  return (
    <div>
      <div className="header">
        <h1>한성마켓</h1>
      </div>
      <div className="menu">
        <Link to="/home/map">Home Map</Link>
      </div>
      <div className="product-list">
        <h2>최신 상품</h2>
        <ul>
          <li>상품 1</li>
          <li>상품 2</li>
          <li>상품 3</li>
        </ul>
        <h2>인기 상품</h2>
        <ul>
          <li>상품 1</li>
          <li>상품 2</li>
          <li>상품 3</li>
        </ul>
      </div>
      <div className="search-bar">
        <input type="text" placeholder="검색어를 입력하세요" />
        <button>검색</button>
      </div>
    </div>
  );
}

export default HomeScreen;
