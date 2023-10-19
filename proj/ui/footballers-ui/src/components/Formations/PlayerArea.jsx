import React, { useState, useReducer, useEffect } from "react";
import { Button } from "react-bootstrap";
import "../../styles/FormationStyle.css";
import * as Icon from 'react-bootstrap-icons';
import FormationPlayerAreaCounter from "../../services/formattion-player-area-counter/FormationPlayerAreaCounter";
import ChoosePlayerDialog from "./ChoosePlayerDialog";
import PitchPlayerCard from "./PitchPlayerCard";

export const PlayerArea = ({teamId, formationData, setFormationData, isViewer}) => {
    
    const [, forceUpdate] = useReducer(x => x + 1, 0);
    const [currentAreaAndPostion, setCurrentAreaAndPostion] = useState([0, 0]);
    const [activate, setActivate] = useState(false);
    const [error, setError] = useState(null);

    function openDialog(area, position) {
        setCurrentAreaAndPostion([area, position]);
        setActivate(true);
    }

    function handleValueChange(value) {
        setFormationData(FormationPlayerAreaCounter.updateFormationData(formationData, currentAreaAndPostion[0], currentAreaAndPostion[1], value));
        setActivate(false);
    }

    const setFree = (area, position, isEdit) => {
        setFormationData(FormationPlayerAreaCounter.updateFormationData(formationData, area, position, 0));
        if (isEdit) {
            setActivate(true);
        } else {
            forceUpdate();
        }
    }

    return(
        <div className="formation__pitch__area">
            <div className="formation__player__area">
                {formationData.playersArray[0][0] === 0 ? 
                    <Button hidden={isViewer} className="formation__player__button" onClick={() => openDialog(0, 0)}><Icon.PlusCircle/></Button> :
                    <PitchPlayerCard playerId={formationData.playersArray[0][0]} setFree={setFree} area={0} position={0} isViewer={isViewer}></PitchPlayerCard>
                }
            </div>
            {
                formationData.playersArray.slice(1).map((playersArray, i) => (
                    <div className="formation__player__area" 
                        style={FormationPlayerAreaCounter.getFormationPlayerAreaData(i + 1, formationData.playersArray.length - 1, playersArray.length)}
                        key={i}>
                        {
                            playersArray.map((player, j) => 
                                {
                                    return player === 0 ? 
                                    <Button hidden={isViewer} className="formation__player__button" onClick={() => openDialog(i + 1, j)} key={j}><Icon.PlusCircle/></Button> :
                                    <PitchPlayerCard playerId={player} setFree={setFree} area={i + 1} position={j}  key={j} isViewer={isViewer}></PitchPlayerCard>
                                }
                            )
                        } 
                    </div> 
                    )
                )
            }
            <ChoosePlayerDialog active={activate} setActive={setActivate} error={error} 
                setError={setError} teamId={teamId} onChangeChoosePlayer={handleValueChange}/>
        </div>
    );
}

export default PlayerArea;