import React, {useEffect, useState} from "react";
import { useSearchParams } from "react-router-dom";
import PlayersList from "../components/Players/PlayersList";
import  "../styles/TeamsListStyle.css";
import  "../styles/PlayersStyle.css";

const PlayersPage = () => {
    const [searchParams] = useSearchParams();
    const [team, setTeam] = useState(null);
    const [teamName, setTeamName] = useState(null);

    useEffect(() => {
        setTeam(searchParams.get("team"));
        setTeamName(searchParams.get("teamName"));
    }, [searchParams])
    

    return (
    <div>
        <h1 className="team__list">Игроки команды {teamName}</h1>
        <div className="pos__and__players__container">
            <PlayersList teamId={team}/>
        </div>
    </div>
    );
}

export default PlayersPage;