import React from "react";
import UrlPath from "../../constans/UrlPath";

const LogOut = () => {

    const logOut = () => {
        localStorage.clear();
        window.location.href = UrlPath.Login;
    }

    return(
        <div className="text-end">
            <button type="button" class="btn btn-link" onClick={() => logOut()}>Выйти</button>
        </div>
    );
}

export default LogOut;