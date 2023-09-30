import React, { useEffect, useState } from "react";
import { useFetching } from "../../hooks/useFetching";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";
import { Alert} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import ConstSpinner from "../UI/ConstSpinner";
import PlayersItem from "./PlayersItem";

const PlayersList = ({teamId, isDialog}) => {

    const [positions, setPositions] = useState([]);
    const [activate, setActivate] = useState(false);
    const [fetchData, isDataLoading, dataError] = useFetching(async () => {
        const response = await CrudService.getAll(ApiPath.PositionsList);
        setPositions(response.data);
    });

    useEffect(() => {
        if (activate === false)
            fetchData();
    }, [activate])

    return (
        <div>
            {dataError && <Alert key='danger' variant='danger'>{dataError}</Alert>}
            {isDataLoading ? <ConstSpinner></ConstSpinner> : 
            <div>
                {positions.map((pos) => 
                    <PlayersItem pos={pos} key={pos.id} activate={activate} setActivate={setActivate} team={teamId}/>
                )} 
            </div>} 
        </div>
    )
}

export default PlayersList;