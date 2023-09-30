import React, {useEffect, useState}  from "react";
import {Button} from 'react-bootstrap';
import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from 'react-router-dom';
import { useSearchParams } from "react-router-dom";
import UrlPath from "../constans/UrlPath";
import Pitch from "../components/Formations/Pitch";

const FormationPage = () => {

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
                <h1 className="team__list">Формации команды {teamName}</h1>
                <Button className="teams__button" variant="light" onClick={
                    () => router(UrlPath.Teams)
                }><Icon.House/> Вернуться к командам</Button>
            </div>
            <div>
                <Pitch teamId={team}></Pitch>
            </div>
        </div>
    );
}

export default FormationPage;