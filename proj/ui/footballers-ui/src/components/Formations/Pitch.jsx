import React from "react";
import { Image } from "react-bootstrap";
import pitch from "../../common/img/pitch.jpg"
import "../../styles/FormationStyle.css";
import PlayerArea from "./PlayerArea";

const Pitch = ({teamId}) => {

    return(
        <div className="formation__pitch__div">
            <Image src={pitch} className="rounded img-responsive"/>
            <PlayerArea teamId={teamId}></PlayerArea>
        </div>
    );
}

export default Pitch;