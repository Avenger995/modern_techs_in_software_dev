import React, {useState, useEffect} from "react";
import { Button } from "react-bootstrap";
import Player from "./Player";
import "../../styles/PlayersStyle.css";
import * as Icon from 'react-bootstrap-icons';
import { DialogTypeEnum } from "../../constans/DialogTypeEnum";
import PlayerAddDialog from "./PlayerAddDialog";

import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const PlayersItem = ({pos, activate, setActivate, team, isDialog, onChangeChoosePlayer}) => {

    const [type, setType] = useState(null);
    const [error, setError] = useState(null);

    const updateType = (type) => {
        setType(type);
        setActivate(true);
      }

      useEffect(() => { 
        if (error !== null) {
            if (error === '') {
                toast.success('Игрок успешно добавлен', {
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
            setError(null);
            setType(null);
        }
      }, [error])

    return(
        <div className="pos__container">
            <div className="label__button">
                <h2>{pos.position}</h2>
                {!isDialog && <Button variant="secondary" onClick={() => updateType(DialogTypeEnum.Add)}><Icon.PlusCircle/></Button>}
            </div>
            <div>
                {pos.players.map(p => 
                    <Player player={p} key={p.id} activate={activate} setActivate={setActivate} 
                        isDialog={isDialog} onChangeChoosePlayer={onChangeChoosePlayer}/>)}
            </div>
            {type === DialogTypeEnum.Add && <PlayerAddDialog active={activate} 
                setActive={setActivate} 
                error={error} 
                setError={setError}
                team={team}
                position={pos.id}/>}
        </div>
    )
}

export default PlayersItem;