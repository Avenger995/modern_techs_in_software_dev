import React, {useState, useEffect} from "react";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";
import { useFetching } from "../../hooks/useFetching";

const GamePlanSelect = ({teamId, handleGamePlanChange, replaceId, setReplaceId}) => {

    const [render, setRender] = useState(true);
    const [gamePlans, setGamePlans] = useState();
    const [fetchGamePlans, isGamePlansLoading, gamePlansError] = useFetching(async () => {
        const response = await CrudService.getById(ApiPath.GetGamePlans, teamId);
        setGamePlans(response.data);
    });
    const [selectedOption, setSelectedOption] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            if (render && !replaceId) {
                await fetchGamePlans();
                setRender(false);
            }
            if (render && replaceId) {
                await fetchGamePlans();
                setRender(false);
                setSelectedOption(replaceId);
            }
        }
        fetchData();
    }, [render])

    useEffect(() => {
        if (selectedOption && replaceId) {
            setReplaceId(null);
            let gamePlanData = gamePlans.find(x => x.id === selectedOption);
            handleGamePlanChange(gamePlanData.array, selectedOption);
        }
    }, [selectedOption])

    const handleChange = (event) => {
        let id = Number(event.target.value);
        setSelectedOption(id);
        let gamePlanData = gamePlans.find(x => x.id === id);
        handleGamePlanChange(gamePlanData.array, id);
    } 

    return( 
        <div>
        {gamePlansError && <p className="text-danger">{gamePlansError}</p>}
        {
            gamePlans && 
            <div>
                <select value={selectedOption} onChange={handleChange}>
                    <option value="" disabled="disabled">Выберите состав</option>
                    {
                        gamePlans.map((gamePlan, index) => 
                            <option value={gamePlan.id} key={index}>{gamePlan.name}</option>
                        )
                    }
                </select>
            </div>
        }
        </div>
    );
}

export default GamePlanSelect;