import React, {useEffect, useState } from "react";
import { Modal, Button, Form, FormLabel} from "react-bootstrap";
import { useFetching } from "../../hooks/useFetching";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";
import { TeamModel } from "../../models/TeamModel";
import Utils from "../../services/utils/utils";

const TeamsDialog = ({active, setActive, error, setError}) => {

    const [validated, setValidated] = useState(false);
    const [fetch, setFetch] = useState(false);
    const [addTeam, isTeamsLoading, teamsError] = useFetching(async (form) => {
        const team = new TeamModel(form[0], form[1], form[2]);
        await CrudService.add(ApiPath.AddTeams, team);
    });

    const handleClose = () => setActive(false);
    const handleSubmit = async (event) => {
        event.preventDefault();
        const form = event.currentTarget;
        const validity = form.checkValidity(); 
        if (validity === false) {
            event.stopPropagation();
        }
        setValidated(true);
        if (validity === true) {
            await validityIsTrue(form)
        }
    } 

    const validityIsTrue = async (form) => {
        const formValue = [form[0].value, 
            form[1].value, 
            await Utils.getFileBytes(form[2].files[0])];
        setValidated(false);
        await addTeam(formValue);
        setFetch(true);
    }

    useEffect(() => {
        if (fetch) {
            setError(teamsError);
            setActive(false);
        }
        setFetch(false);
    }, [fetch])

    return (
        <Modal show={active} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Добавление новой команды</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <FormLabel>Название команды</FormLabel>
                <Form.Control required type="text" placeholder="Название команды"/>
                <FormLabel>Короткое название команды</FormLabel>
                <Form.Control required type="text" placeholder="Короткое название команды"/>
                <FormLabel>Логотип</FormLabel>
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

export default TeamsDialog;