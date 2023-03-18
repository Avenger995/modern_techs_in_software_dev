import React, {useState} from "react";
import { Modal, Form, FormLabel, Button } from "react-bootstrap";
import ApiPath from "../../constans/ApiPath";
import CrudService from "../../services/CrudService";
import { PlayerAddModel, PlayerEditModel } from "../../models/PlayerModel";
import Utils from "../../services/utils/utils";
import { useFetching } from "../../hooks/useFetching";

const PlayerAddDialog = ({active, setActive, error, setError, team, position}) => {
    
    const [validated, setValidated] = useState(false);

    const [addPlayer, isPlayerLoading, playersError] = useFetching(async (form) => {
        await CrudService.add(ApiPath.AddPlayer, 
            fillFormDto(form[0].value, 
            form[1].value, 
            form[2].value, 
            await Utils.getFileBytes(form[3].files[0])));
    });

    const handleClose = () => setActive(false);
    const handleSubmit = async (event) => {
        event.preventDefault();
        const form = event.currentTarget;
        const validity = form.checkValidity(); 
        if (validity === true) {
            event.stopPropagation();
            await addPlayer(form);
            afterValidity(); 
        }
        setValidated(true);
    }

    const afterValidity = () => {
        setError(playersError);
        setActive(false);
    }

    const fillFormDto = (name, number, age, img) => {
        return new PlayerAddModel(0, name, number, age, img, position, team); 
    }

    return(
        <Modal show={active} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Добавление нового игрока</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <FormLabel>Имя</FormLabel>
                <Form.Control required type="text" placeholder="Имя"/>
                <FormLabel>Номер</FormLabel>
                <Form.Control required type="number" placeholder="Номер"/>
                <FormLabel>Возраст</FormLabel>
                <Form.Control required type="number" placeholder="Возраст"/>
                <FormLabel>Фото</FormLabel>
                <Form.Control 
                    required 
                    type="file"
                    name="file" 
                    placeholder="Выберите файл"/>
                <br/>
                <Modal.Footer>
                    <Button type="submit">
                        Добавить
                    </Button>
                </Modal.Footer>
            </Form>
        </Modal.Body>
      </Modal>
    );
}

export default PlayerAddDialog;