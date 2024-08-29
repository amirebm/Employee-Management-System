import "./App.css";
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import "bootstrap/dist/css/bootstrap.min.css";
import HelloWorld from "./Hello-World.jsx";
import ListEmployeeComponent from "./Components/ListEmployeeComponent.jsx";
import HeaderComponent from "./Components/HeaderComponent.jsx";
import { FooterComponent} from "./Components/FooterComponent.jsx";
import {BrowserRouter , Routes, Route} from 'react-router-dom'
function App() {
  return (
    <>
<BrowserRouter>
      <HeaderComponent />
      <Routes>
        {/* //http://localhost:8080 */}
        <Route path="/" element={<ListEmployeeComponent />}></Route>
        {/* //http://localhost:8080/employees */}
        <Route path="/employees" element={<ListEmployeeComponent />}></Route>
      </Routes>
      <FooterComponent />
    </BrowserRouter>   
     </>
  );
}

export default App;
