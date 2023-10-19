import React, {useState, useEffect} from "react";
import { useFetching } from "../../hooks/useFetching";
import CrudService from "../../services/CrudService";
import ApiPath from "../../constans/ApiPath";

const FormationSelect = ({handleFormationChange}) => {

    const [render, setRender] = useState(true);
    const [formations, setFormation] = useState();
    const [fetchFormations, isFormtationsLoading, formationsError] = useFetching(async () => {
        const response = await CrudService.getAll(ApiPath.GetFormationList);
        setFormation(response.data);
    });
    const [selectedOption, setSelectedOption] = useState('');

    useEffect(() => {
        if (render) {
            fetchFormations();
            setRender(false);
        }
    }, [render])

    const handleChange = (event) => {
        let id = Number(event.target.value);
        setSelectedOption(id);
        let formationData = formations.find(x => x.id === id);
        handleFormationChange(formationData.id, formationData.formation);
    } 

    return( 
        <div>
        {formationsError && <p className="text-danger">{formationsError}</p>}
        {
            formations && 
            <div>
                <select value={selectedOption} onChange={handleChange}>
                    <option value="" disabled="disabled">Выберите схему</option>
                    {
                        formations.map((formation, index) => 
                            <option value={formation.id} key={index}>{formation.formation}</option>
                        )
                    }
                </select>
            </div>
        }
        </div>
    );
}

export default FormationSelect;