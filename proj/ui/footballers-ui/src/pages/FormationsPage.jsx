import React, {useEffect, useState}  from "react";
import {Button} from 'react-bootstrap';
import * as Icon from 'react-bootstrap-icons';
import {useNavigate} from 'react-router-dom';
import { useSearchParams } from "react-router-dom";
import UrlPath from "../constans/UrlPath";
import Pitch from "../components/Formations/Pitch";
import FormationSelect from "../components/Formations/FormationSelect";
import { Formation } from "../models/Formation";
import "../styles/FormationStyle.css";
import FormationPlayerAreaCounter from "../services/formattion-player-area-counter/FormationPlayerAreaCounter";
import CrudService from "../services/CrudService";
import { GamePlansModel } from "../models/GamePlansModel";
import ApiPath from "../constans/ApiPath";
import GamePlanSelect from "../components/Formations/GamePlanSelect";

import {  ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Utils from "../services/utils/utils";

const FormationPage = () => {

    const [searchParams] = useSearchParams();
    const [team, setTeam] = useState(null);
    const [teamName, setTeamName] = useState(null);
    const [gamePlanName, setGamePlanName] = useState('');
    const [formation, setFormation] = useState();
    const [formationData, setFormationData] = useState();
    const [isButtonAvailable, setIsButtonAvailable] = useState(false);
    const [error, setError] = useState(null);
    const [isViewer, setIsViewer] = useState();
    const [isRenderPitch, setIsRenderPitch] = useState(false);
    const [replaceId, setReplaceId] = useState();
    const [gamePlanId, setGamePlanId] = useState(false);
    const [isReloadGamePlans, setIsReloadGamePlans] = useState(false);
    const [dtCreation, setDtCreation] = useState(undefined);
    const [owner, setOwner] = useState(undefined);

    useEffect(() => {
        if (isReloadGamePlans) {
            setIsReloadGamePlans(false);
        }
    }, [isReloadGamePlans])

    useEffect(() => {
        setTeam(searchParams.get("team"));
        setTeamName(searchParams.get("teamName"));
        setIsViewer(searchParams.get("isViewer"));
    }, [searchParams])

    useEffect(() => {
        if (formation) {
            setFormationData(FormationPlayerAreaCounter.readFormation(formation.name));
            setIsRenderPitch(true);
        }
        
    }, [formation])

    useEffect(() => {
        setIsButtonAvailable(formation && gamePlanName);
    }, [formation, gamePlanName])


    useEffect(() => {
        setIsRenderPitch(true);
    }, [formationData])

    useEffect(() => { 
        if (error !== null) {
            if (error === '') {
                toast.success('Состав успешно сохранён', {
                    position: "top-center",
                    autoClose: 5000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                    });
                return;
            } 
            if (error === 'del') {
                toast.success('Состав успешно удалён', {
                    position: "top-center",
                    autoClose: 5000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                    });
                return;
            } 
            if (error !== '') {
                toast.error(error, {
                    position: "top-center",
                    autoClose: 5000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: "light",
                    });
                return;
            }
            setError(null);
        }
      }, [error])

    const router = useNavigate();

    const handleFormationChange = (formationId, formationName) => {
        setFormation(new Formation(formationId, formationName));
    }

    const handleGamePlanChange = (array, id, dtCreation, owner) => {
        setIsRenderPitch(false);
        setGamePlanId(id);
        setOwner(owner);
        setDtCreation(`${new Date(dtCreation).toLocaleDateString()} ${new Date(dtCreation).toLocaleTimeString()}`);
        setFormationData({...FormationPlayerAreaCounter.setFormationData(array)});
        if (array) setIsButtonAvailable(true);
    }

    const handleSave = async () => {
        let obj = new GamePlansModel(0, formation.id, gamePlanName, team, formationData.playersArray, Utils.getLogin());
        let res = await addGamePlan(obj);
        if (res) {
            setError('');
            setReplaceId(res);
            setIsViewer(true);
        }
    }

    const addGamePlan = async (obj) => {
        try {
            let res = await CrudService.add(ApiPath.AddGamePlan, obj);
            return res.data;
        } catch (error) {
            setError(error.message);
            return false;
        }
    }

    const updateGamePlanName = (event) => {
        setGamePlanName(event.target.value);
    }

    const goBack = () => {
        router(UrlPath.Teams);
    }

    const deleteFormation = async () => {
        const response = await deleteFormationCrud();
        if (response) {
            setDtCreation(undefined);
            setOwner(undefined);
            setFormationData();
            setIsRenderPitch(false);
            setIsReloadGamePlans(true);
        }
    }

    const deleteFormationCrud = async () => {
        try {
            await CrudService.deleteById(ApiPath.DeleteGamePlans, gamePlanId);
            setError('del');
            return true;
        } catch (error) {
            setError(error.message);
            return false;
        }
    }

    return (
        <div>
            <div className="players__title">
                {isViewer ? <h1 className="team__list">Составы команды {teamName}</h1> : <h1 className="team__list">Новый состав команды {teamName}</h1>}
                <Button className="teams__button" variant="light" onClick={
                    () => goBack()
                }><Icon.House/> Вернуться к командам</Button>
            </div>
            {isViewer ? 
            <div className="formation__dropdown">
                {!isReloadGamePlans && 
                    <GamePlanSelect teamId={team} handleGamePlanChange={handleGamePlanChange} replaceId={replaceId} setReplaceId={setReplaceId}></GamePlanSelect>}
                <Button className="btn-secondary" variant="danger" onClick={() => deleteFormation()} disabled={!isButtonAvailable}><Icon.Trash/> Удалить</Button>
                {isRenderPitch && dtCreation && owner && <label >Дата создания состава: {dtCreation}. Владелец: {owner}</label>}
            </div> 
            :
            <div className="formation__dropdown">
                <FormationSelect handleFormationChange={handleFormationChange}></FormationSelect>
                <input type="text" placeholder="Введите название состава" className="w-25" onChange={updateGamePlanName}></input>
                <Button className="btn-success" onClick={async () => await handleSave()} disabled={!isButtonAvailable}><Icon.Save/> Сохранить</Button>
                <Button className="btn-secondary" onClick={() => handleFormationChange(formation.id, formation.name)}><Icon.Trash/> Очистить</Button>
            </div>
            }
            {
                formationData && isRenderPitch && 
                <div>
                    <Pitch teamId={team} formationData={formationData} setFormationData={setFormationData} isViewer={isViewer}></Pitch>
                </div>
            }
            
        </div>
    );
}

export default FormationPage;