import React, { useEffect, useState}  from "react";
import { Button } from "react-bootstrap";
import '../../styles/LoginStyles.css';
import CrudService from '../../services/CrudService';
import ApiPath from "../../constans/ApiPath";
import LocalStorageConsts from "../../constans/LocalStorageConsts";
import {useNavigate} from 'react-router-dom';
import UrlPath from "../../constans/UrlPath";

const SignIn = () => {

    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [serverError, setServerError] = useState(null);
    const [isNeedToClean, setIsNeedToClean] = useState(false);

    const router = useNavigate();

    useEffect(() => {
        if (isNeedToClean) {
            setLogin('');
            setPassword('');
            setIsNeedToClean(false);
        }
    }, [isNeedToClean])

    const updateLogin = (event) => {
        setLogin(event.target.value);
    }

    const updatePassword = (event) => {
        setPassword(event.target.value);
    }

    const signIn = async () => {
        let response = await trySignIn();
        if (response?.message) {
            setServerError(response?.response?.data);
            setIsNeedToClean(true);
            return;
        } 
        if (response?.status === 200) {
            localStorage.setItem(LocalStorageConsts.Token, response.data.accessToken);
            localStorage.setItem(LocalStorageConsts.Login, login);
            window.location.href = UrlPath.Teams;
            return;
        } 
        setServerError('Неверные логин и/или пароль');
        setIsNeedToClean(true);
    }

    const trySignIn = async () => {
        try {
            let loginForm = {login: login, password: password};
            let res = await CrudService.login(ApiPath.Login, loginForm);
            return res;
        } catch (error) {
            return error;
        }
    }

    return(
        <div id="form-container">
            <div id="form-inner-container">
                <div id="sign-up-container">
                    {serverError && <p className="text-danger">{serverError}</p>}
                    <h2>Авторизация</h2>

                    <form>
                        <label>Логин</label>
                        <input type="text" placeholder="Введите логин" onChange={updateLogin} value={login}></input>

                        <label>Пароль</label>
                        <input type="password" placeholder="Введите пароль" onChange={updatePassword} value={password}></input>

                        <div className="text-center">
                            <Button type="submit" className="mt-3" onClick={async () => signIn()}>Войти</Button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default SignIn;