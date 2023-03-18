import React, {useState} from "react";
import { Modal, Form, FormLabel, Button } from "react-bootstrap";
import ApiPath from "../../constans/ApiPath";
import CrudService from "../../services/CrudService";
import { PlayerEditModel } from "../../models/PlayerModel";
import Utils from "../../services/utils/utils";
import { useFetching } from "../../hooks/useFetching";

const PlayerEditDialog = ({active, setActive, error, setError, player}) => {
    
    const [validated, setValidated] = useState(false);

    const [editPlayer, isPlayerLoading, playersError] = useFetching(async (form) => {
        await CrudService.update(ApiPath.UpdatePlayer, 
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
            await editPlayer(form);
            afterValidity(); 
        }
        setValidated(true);
    }

    const afterValidity = () => {
        setError(playersError);
        setActive(false);
    }

    const fillFormDto = (name, number, age, img) => {
        return new PlayerEditModel(player.id, name, number, age, img); 
    }

    return(
        <Modal show={active} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Изменение данных игрока {player.name}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <FormLabel>Имя</FormLabel>
                <Form.Control required type="text" placeholder="Имя" defaultValue={player.name}/>
                <FormLabel>Номер</FormLabel>
                <Form.Control required type="number" placeholder="Номер" defaultValue={player.number}/>
                <FormLabel>Возраст</FormLabel>
                <Form.Control required type="number" placeholder="Возраст" defaultValue={player.age}/>
                <FormLabel>Фото</FormLabel>
                <Form.Control 
                    required 
                    type="file"
                    name="file" 
                    placeholder="Выберите файл"/>
                <br/>
                <Modal.Footer>
                    <Button type="submit">
                        Изменить
                    </Button>
                </Modal.Footer>
            </Form>
        </Modal.Body>
      </Modal>
    );

}

export default PlayerEditDialog;