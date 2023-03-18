import React, {useState, useEffect} from "react";
import * as Icon from 'react-bootstrap-icons';
import {Button, Card} from 'react-bootstrap';
import '../../styles/PlayersStyle.css';
import PlayerEditDialog from "./PlayerEditDialog";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { DialogTypeEnum } from "../../constans/DialogTypeEnum";

const Player = ({player, activate, setActivate, team}) => {

  const [hover, setHover] = useState();
  const [error, setError] = useState(null);
  const [type, setType] = useState(null);

  const handleMouseIn = () => {
    setHover(true);
  };

  const handleMouseOut = () => {
    setHover(false);
  };

  useEffect(() => { 
    if (error !== null) {
        if (error === '') {
            toast.success('Информация об игроке успешно изменена', {
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

  const updateType = (type) => {
    setType(type)
    setActivate(true);
  }

    return (
      <div>
        <Card style={{ width: '10rem', textAlign:'center', margin: '1rem' }} className="player__card" onMouseOver={handleMouseIn} onMouseOut={handleMouseOut}>
        <div className="player__button__container">
            <Card.Img className="player__custom_img" variant="top" src={`${player.img}`}/> 
            <br/>
            <Button className="player__button" variant="light" hidden={!hover} onClick={() => updateType(DialogTypeEnum.Upd)}><Icon.PencilFill/></Button>
            <Button className="player__button" variant="danger"  hidden={!hover}><Icon.Trash3Fill/></Button>
        </div>
        <Card.Body>
            <Card.Text>{player.name}</Card.Text>
        </Card.Body>
        </Card>
        {type === DialogTypeEnum.Upd && <PlayerEditDialog active={activate} setActive={setActivate} error={error} setError={setError} player={player}/>}
      </div>
    );
}

export default Player;