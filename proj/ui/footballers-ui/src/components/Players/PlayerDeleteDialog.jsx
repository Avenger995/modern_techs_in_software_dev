import React, { useEffect, useState } from "react";
import { Modal, Button, Form, FormLabel} from "react-bootstrap";
import CrudService from "../../services/CrudService";
import { useFetching } from "../../hooks/useFetching";
import ApiPath from "../../constans/ApiPath";

const PlayerDeleteDialog = ({active, setActive, error, setError, name, id}) => {

    const [fetch, setFetch] = useState(false);
    const [deletePlayer, isPlayerLoading, playerError] = useFetching( async (id) => {
        await CrudService.deleteById(ApiPath.DeletePlayer, id);
    });

    const handleClose = () => setActive(false);
    const handleSubmit = async (event) => {
        event.preventDefault();
        event.stopPropagation();
        await deletePlayer(id);
        setFetch(true);
    }

    useEffect(() => {
        if (fetch) {
            setError(playerError);
            setActive(false);
        }
        setFetch(false);
    }, [fetch]);

    return(
        <Modal show={active} onHide={handleClose}>
            <Modal.Header closeButton>
          <Modal.Title>Удаление игрока</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form noValidate onSubmit={handleSubmit}>
            <FormLabel>Вы действительно хотите удалить игрока {name}?</FormLabel>
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

export default PlayerDeleteDialog;