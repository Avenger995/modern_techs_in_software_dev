import React from "react";
import AppRouter from "./components/AppRouter";
import {BrowserRouter} from "react-router-dom";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <AppRouter/>
        <ToastContainer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
