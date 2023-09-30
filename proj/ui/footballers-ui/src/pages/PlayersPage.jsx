import React, {useEffect, useState} from "react";
import {Button} from 'react-bootstrap';
import * as Icon from 'react-bootstrap-icons';
import { useSearchParams } from "react-router-dom";
import PlayersList from "../components/Players/PlayersList";
import UrlPath from "../constans/UrlPath";
import  "../styles/TeamsListStyle.css";
import  "../styles/PlayersStyle.css";
import {useNavigate} from 'react-router-dom';

const PlayersPage = () => {
    const [searchParams] = useSearchParams();
    const [team, setTeam] = useState(null);
    const [teamName, setTeamName] = useState(null);

    useEffect(() => {
        setTeam(searchParams.get("team"));
        setTeamName(searchParams.get("teamName"));
    }, [searchParams])
    
    const router = useNavigate();

    return (
    <div>
        <div className="players__title">
            <h1 className="team__list">Игроки команды {teamName}</h1>
            <Button className="teams__button" variant="light" onClick={
                () => router(UrlPath.Teams)
            }><Icon.House/> Вернуться к командам</Button>
        </div>
        <div className="pos__and__players__container">
            <PlayersList teamId={team} isDialog={false}/>
        </div>
    </div>
    );
}

export default PlayersPage;