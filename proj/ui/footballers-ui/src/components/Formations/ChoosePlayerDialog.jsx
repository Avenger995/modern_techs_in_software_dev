import React, { useState } from "react";
import { Modal } from "react-bootstrap";
import PlayersList from "../Players/PlayersList";


const ChoosePlayerDialog = ({active, setActive, error, setError, teamId, onChangeChoosePlayer, chosenPlayers}) => {
    
    const [fetch, setFetch] = useState(false);

    const handleClose = () => setActive(false);

    return(
        <div>
            <Modal className="modal-lg modal-ku" show={active} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Выберите игрока на позицию</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <PlayersList teamId={teamId} isDialog={true} onChangeChoosePlayer={onChangeChoosePlayer} chosenPlayers={chosenPlayers}></PlayersList>
                </Modal.Body>
            </Modal>
        </div>
    );
}

export default ChoosePlayerDialog;