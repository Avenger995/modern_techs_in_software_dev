import React, {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Button, Card} from 'react-bootstrap';
import '../../styles/TeamsItemStyle.css';
import * as Icon from 'react-bootstrap-icons';
import TeamDeleteDialog from "./TeamDeleteDialog";
import {useNavigate} from 'react-router-dom';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import UrlPath from "../../constans/UrlPath";
import UrlKeys from "../../constans/UrlKeys";

const TeamsItem = ({team, deleteTeam, setDeleteTeam}) => {

    const [activate, setActive] = useState(false);
    const [error, setError] = useState(null);
    const router = useNavigate();

    useEffect(() => { 
        if (error !== null) {
            if (error === '') {
                toast.success('Команда успешно удалена', {
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
            if (error !== '') {
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
            setDeleteTeam(true);
            setError(null);
        }
    }, [error])

    return(
        <Card style={{ width: '25rem', textAlign:'center', margin: '1rem' }}>
        <Card.Img className="teams__img" variant="top" src={`${team.img}`} /> 
        <Card.Body>
            <Card.Title>{team.name}</Card.Title>
            <Card.Text>{team.shortName}</Card.Text>
            <Button className="teams__button" variant="primary"><Icon.Journal/> Формации</Button>
            <Button className="teams__button" variant="light" onClick={() => router(UrlPath.Players.concat(`?${UrlKeys.TeamKey}=${team.id}&${UrlKeys.TeamName}=${team.name}`))}><Icon.PeopleFill/> Игроки</Button>
            <Button className="teams__button" variant="danger" onClick={async () => setActive(true)}><Icon.Trash3Fill/> Удалить</Button>
            <TeamDeleteDialog active={activate} setActive={setActive} error={error} setError={setError} name={team.name} id={team.id}/>
        </Card.Body>
        </Card>
    );
}

export default TeamsItem;