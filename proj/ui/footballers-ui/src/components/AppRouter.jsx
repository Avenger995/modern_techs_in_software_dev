import React, { useState } from "react";
import {Navigate, Route, Routes} from "react-router-dom";
import UrlPath from "../constans/UrlPath";
import { routes, loginRoute } from "../router/routes";
import LocalStorageConsts from "../constans/LocalStorageConsts";

const AppRouter = () => {

    const [isLogined, setIsLogined] = useState(localStorage.getItem(LocalStorageConsts.Login))

    return (
        <Routes>
            { isLogined && routes.map(route =>
                <Route
                    element={route.element}
                    path={route.path}
                    exact={route.exact}
                    key={route.path}    
                />
            )}
            { isLogined && <Route path="*" element={<Navigate to={UrlPath.Teams} replace />} /> }

            { !isLogined && 
                <Route
                    element={loginRoute.element}
                    path={loginRoute.path}
                    exact={loginRoute.exact}
                    key={loginRoute.path}    
                />}
            { !isLogined &&  <Route path="*" element={<Navigate to={UrlPath.Login} replace />} />}
        </Routes>
    )
}

export default AppRouter;