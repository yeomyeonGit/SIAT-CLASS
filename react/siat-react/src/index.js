import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

// import UserList from './test/UserList';
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <UserList />  
//     {/* "index.js에서 UserList 컴포넌트를 root에 렌더링한다"** */}
//     {/* 하나의 js 파일을 태그로 사용한다 */}
//   </React.StrictMode>
// );

// import Avatar from "./test/Avatar";
// import AvatarList from './test/AvatarList';
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <AvatarList />  
//     {/* App.js 파일을 index.html에서 사용하고 싶으면 여기에 컴포넌트로 등록한다. */}
//     {/* 하나의 js 파일을 태그로 사용한다 */}
//   </React.StrictMode>
// );

// import Library from './test/Library';
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <Library />  
//     {/* App.js 파일을 index.html에서 사용하고 싶으면 여기에 컴포넌트로 등록한다. */}
//     {/* 하나의 js 파일을 태그로 사용한다 */}
//   </React.StrictMode>
// );

// import App from './App'; 
// js 파일을 App이라는 이름으로 import
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <App />  
//     {/* App.js 파일을 index.html에서 사용하고 싶으면 여기에 컴포넌트로 등록한다. */}
//     {/* 하나의 js 파일을 태그로 사용한다 */}
//   </React.StrictMode>
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

// import Interlocking from './test/Interlocking';
// // 라이브러리를 등록해
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <Interlocking />  
//     {/* App.js 파일을 index.html에서 사용하고 싶으면 여기에 컴포넌트로 등록한다. */}
//     {/* 하나의 js 파일을 태그로 사용한다 */}
//   </React.StrictMode>
// );

// import CommentList from './component/CommentList';
// // 라이브러리를 등록해
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   // <React.StrictMode> 필요 없음. 다음부터 안 쓸거임.
//     <CommentList />  
//   // </React.StrictMode>
// );
// reportWebVitals();

// import Counter from './state/Counter';
// // 라이브러리를 등록해
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//     <Counter />  
// );
// reportWebVitals();

import StateSample from './state/StateSample';
// 라이브러리를 등록해
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <StateSample />  
);
reportWebVitals();