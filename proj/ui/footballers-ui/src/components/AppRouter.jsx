import React, { useState } from "react";
import {Navigate, Route, Routes} from "react-router-dom";
import UrlPath from "../constans/UrlPath";
import { routes } from "../router/routes";

const AppRouter = () => {

    const [isLogined, setIsLogined] = useState()

    return (
        <Routes>
            {routes.map(route =>
                <Route
                    element={route.element}
                    path={route.path}
                    exact={route.exact}
                    key={route.path}    
                />
            )}
            <Route path="*" element={<Navigate to={UrlPath.Login} replace />} />
        </Routes>
    )
}

export default AppRouter;