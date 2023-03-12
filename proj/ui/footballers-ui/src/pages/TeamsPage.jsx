import React, {useEffect, useState} from "react";
import {Button} from 'react-bootstrap';
import * as Icon from 'react-bootstrap-icons';
import TeamsDialog from "../components/Teams/TeamsDialog";
import TeamsList from "../components/Teams/TeamsList";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const TeamsPage = () => {

    const [showModal, setShowModal] = useState(false);
    const [error, setError] = useState(null);

    useEffect( () => {
        if (error === '') {
            toast.success('Команда успешно добавлена', {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
                });
        } 
        if (error !== '' && error !== null) {
            toast.error(error, {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
                });
        }
        setError(null);
    }, [error]);

    return(
        <div>
            <div className="team__div__center">
                <h1>Доступные команды</h1>
                <Button variant="success" onClick={() => setShowModal(true)}><Icon.PlusCircle/> Добавить новую команду</Button>
            </div>
            <div>
                <TeamsList render={showModal}/>
            </div>
            <TeamsDialog active={showModal} setActive={setShowModal} error={error} setError={setError}/>
           
        </div>
    );
}

export default TeamsPage;