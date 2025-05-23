import logo from './logo.svg';
import './App.css';
import IndexPage from './page/IndexPage';
import { BrowserRouter, Route, Routes } from "react-router-dom"
import SignUp from './page/SignUp';

function App() {
  return (
    <BrowserRouter>
      <h2>Docker 환경의 통신</h2>
      <Routes>
        <Route path="/"                element={ <IndexPage />}></Route>
        <Route path="/api/user/signUp" element={ <SignUp />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App ;
