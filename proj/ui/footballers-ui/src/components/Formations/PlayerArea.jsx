import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import "../../styles/FormationStyle.css";
import * as Icon from 'react-bootstrap-icons';
import FormationPlayerAreaCounter from "../../services/formattion-player-area-counter/FormationPlayerAreaCounter";
import ChoosePlayerDialog from "./ChoosePlayerDialog";

export const PlayerArea = ({teamId}) => {

    const [goalkeeperId, setGoalkeeperId] = useState(0);
    const [activate, setActivate] = useState(false);
    const [error, setError] = useState(null);

    let firstPlayerArea = FormationPlayerAreaCounter.getFormationPlayerAreaData(1, 3, 4);
    let secondPlayerArea = FormationPlayerAreaCounter.getFormationPlayerAreaData(2, 3, 5);
    let thirdPlayerArea = FormationPlayerAreaCounter.getFormationPlayerAreaData(3, 3, 1);

    return(
        <div className="formation__pitch__area">
            <div className="formation__player__area">
                {goalkeeperId === 0 ? 
                    <Button className="formation__player__button" onClick={async () => setActivate(true)}><Icon.PlusCircle/></Button> :
                    <Button className="formation__player__button" onClick={() => setGoalkeeperId(0)}><Icon.CreditCard/></Button>
                }
            </div>
            <div className="formation__player__area" style={firstPlayerArea}>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
            </div>
            <div className="formation__player__area" style={secondPlayerArea}>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
            </div>
            <div className="formation__player__area" style={thirdPlayerArea}>
                <Button className="formation__player__button"><Icon.PlusCircle/></Button>
            </div>
            <ChoosePlayerDialog active={activate} setActive={setActivate} error={error} setError={setError} teamId={teamId} id={goalkeeperId}/>
        </div>
    );
}

export default PlayerArea;