import React, { useState } from "react";
import { Modal } from "react-bootstrap";
import PlayersList from "../Players/PlayersList";


const ChoosePlayerDialog = ({active, setActive, error, setError, teamId, onChangeChoosePlayer}) => {
    
    const [fetch, setFetch] = useState(false);

    const handleClose = () => setActive(false);

    return(
        <Modal show={active} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Выберите игрока на позицию</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <PlayersList teamId={teamId} isDialog={true} onChangeChoosePlayer={onChangeChoosePlayer}></PlayersList>
            </Modal.Body>
        </Modal>
    );
}

export default ChoosePlayerDialog;