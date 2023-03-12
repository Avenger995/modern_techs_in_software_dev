import React from "react";
import {Navigate, Route, Routes} from "react-router-dom";
import UrlPath from "../constans/UrlPath";
import { routes } from "../router/routes";

const AppRouter = () => {
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
            <Route path="*" element={<Navigate to={UrlPath.Teams} replace />} />
        </Routes>
    )
}

export default AppRouter;