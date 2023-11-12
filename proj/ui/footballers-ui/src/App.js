import React from "react";
import AppRouter from "./components/AppRouter";
import {BrowserRouter} from "react-router-dom";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import LogOut from "./components/LogOut/LogOut";
import Utils from "./services/utils/utils";

function App() {
  return (
    <div className="App">
      {Utils.getJwt() && <LogOut/>}
      <BrowserRouter>
        <AppRouter/>
          <ToastContainer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
