import React, { useEffect, useState } from "react";
import { Modal, Button, Form, FormLabel} from "react-bootstrap";
import CrudService from "../../services/CrudService";
import { useFetching } from "../../hooks/useFetching";
import ApiPath from "../../constans/ApiPath";

const TeamDeleteDialog = ({active, setActive, error, setError, name, id}) => {
    const [fetch, setFetch] = useState(false);
    const [deleteTeam, isTeamsLoading, teamsError] = useFetching( async (id) => {
        await CrudService.deleteById(ApiPath.DeleteTeams,id);
    });
    const handleClose = () => setActive(false);
    const handleSubmit = async (event) => {
        event.preventDefault();
        event.stopPropagation();
        await deleteTeam(id);
        setFetch(true);
    }

    useEffect(() => {
        if (fetch) {
            setError(teamsError);
            setActive(false);
        }
        setFetch(false);
    }, [fetch]);

    return(
        <Modal show={active} onHide={handleClose}>
            <Modal.Header closeButton>
          <Modal.Title>Удаление команды</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form noValidate onSubmit={handleSubmit}>
            <FormLabel>Вы действительно хотите удалить команду {name}?</FormLabel>
            <Modal.Footer>
            <Button type="submit" variant="danger">
                    Да
            </Button>
            </Modal.Footer>
            </Form>
        </Modal.Body>
        </Modal>
    )
}

export default TeamDeleteDialog;