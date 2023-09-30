import React, { useState } from "react";
import { Modal } from "react-bootstrap";


const ChoosePlayerDialog = ({active, setActive, error, setError, teamId, id}) => {
    
    const [fetch, setFetch] = useState(false);

    const handleClose = () => setActive(false);

    return(
        <Modal show={active} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>id = {teamId}</Modal.Title>
            </Modal.Header>

        </Modal>
    );
}

export default ChoosePlayerDialog;