import React, {useState, useEffect} from "react";
import TeamsItem from "./TeamsItem";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Spinner, Alert, Row} from 'react-bootstrap';
import { useFetching } from "../../hooks/useFetching";
import  "../../styles/TeamsListStyle.css";


const TeamsList = ({render}) => {

    const [teams, setTeams] = useState([])
    const [fetchTeams, isTeamsLoading, teamsError] = useFetching(async () => {
        const response = await CrudService.getAll(ApiPath.Teams);
        setTeams(response.data);
    });
    const [deleteTeam, setDeleteTeam] = useState(null);

    useEffect(() => {
        if (render !== null) {
            fetchTeams();
        }
    }, [render])

    useEffect(() => {
        if (deleteTeam !== null) {
            fetchTeams();
            setDeleteTeam(null);
        }
    }, [deleteTeam])

    return(
        <div>
            <div className="team__list">
                {teamsError && 
                <Alert key='danger' variant='danger'>
                    {teamsError}
                </Alert>}
                {isTeamsLoading ? <Spinner animation="border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </Spinner> :
                    <Row xs={1} md={2} className="row-custom">
                    {teams.map((team) => 
                        <TeamsItem team={team} key={team.id} deleteTeam={deleteTeam} setDeleteTeam={setDeleteTeam}/>
                    )}
                    </Row>
                }
            </div>
        </div>
    );
}

export default TeamsList;