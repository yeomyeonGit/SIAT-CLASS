import { BrowserRouter, Route, Routes } from "react-router-dom"
import './App.css';
import IndexPage from "./pages/IndexPage";
import LoginForm from "./event/LoginForm";
import SuccessPage from "./pages/SuccessPage";
import TodoView from "./items/TodoView";


function App() {
  return (
    <BrowserRouter>
      <h2>페이지 이동을 위한 라우터 연습</h2>
      <Routes>
        <Route path="/" element={ <IndexPage />}></Route>
        <Route path="/user/loginForm" element={ <LoginForm />}></Route>
        <Route path="/user/success" element={ <SuccessPage />}></Route>
        <Route path="/todo/details" element={ <TodoView />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
