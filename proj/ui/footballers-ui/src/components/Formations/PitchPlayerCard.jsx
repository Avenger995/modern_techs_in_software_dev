import React, {useState, useEffect} from "react";
import { useFetching } from "../../hooks/useFetching";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";
import { Card, Button} from 'react-bootstrap';
import '../../styles/PitchPlayerStyle.css';
import { Alert} from 'react-bootstrap';
import ConstSpinner from "../UI/ConstSpinner";
import * as Icon from 'react-bootstrap-icons';


const PitchPlayerCard = ({playerId, setFree}) => {

    const [hover, setHover] = useState();
    const [render, setRender] = useState(true);
    const [player, setPlayer] = useState();
    const [fetchPlayer, isPlayerLoading, playerError] = useFetching(async () => {
        const response = await CrudService.getById(ApiPath.GetPlayer, playerId);
        setPlayer(response.data);
    });

    const handleMouseIn = () => {
        setHover(true);
      };
    
      const handleMouseOut = () => {
        setHover(false);
      };

    useEffect(() => {
        if (render) {
            fetchPlayer();
            setRender(false);
        }
    }, [render])

    return (
        <div>
            {player && 
            <div>
            {playerError && <Alert key='danger' variant='danger'>{playerError}</Alert>}
            {isPlayerLoading ? <ConstSpinner></ConstSpinner> : 
            <Card className="pitch__player__card" onMouseOver={handleMouseIn} onMouseOut={handleMouseOut}>
                <button hidden={!hover} className="pitch__player__icon" onClick={() => setFree()}><Icon.DashCircle/></button>
                <Card.Img className="pitch__player__custom_img" variant="top" src={`${player.img}`}/>
                <Card.Body>
                    <Card.Text>{player.name}</Card.Text>
                </Card.Body>
            </Card>
            }
            </div>}
        </div>
    );
}

export default PitchPlayerCard;