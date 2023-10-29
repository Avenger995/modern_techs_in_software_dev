import Enviroment from "../enviroment/Enviroment";

export const Teams = Enviroment.ApiUrl + 'teams';
export const AddTeams = Teams;
export const DeleteTeams = Teams + '/';

export const PlayersByTeam = Enviroment.ApiUrl + 'players';
export const UpdatePlayer = PlayersByTeam;
export const AddPlayer = PlayersByTeam;
export const DeletePlayer = PlayersByTeam;
export const GetPlayer = PlayersByTeam;

export const PositionsList = Enviroment.ApiUrl + 'positions';
export const PositionsListByTeam = PositionsList + '/by-team';

export const FormationList = Enviroment.ApiUrl + 'formations';

export const GamePlan = Enviroment.ApiUrl + 'game-plan';
export const AddGamePlan = GamePlan;
export const DeleteGamePlan = GamePlan;
export const GetGamePlanByTeam = GamePlan + '/by-team';

export const Headers = {'Accept': 'application/json',
    'Content-Type': 'application/json'}

export default class ApiPath {
    static get Headers() {
        return Headers;
    }

    static get Teams() {
        return Teams;
    } 

    static get AddTeams() {
        return AddTeams;
    }
    static get DeleteTeams() {
        return DeleteTeams;
    }

    static get PositionsList() {
        return PositionsList;
    }

    static get PositionsListByTeam() {
        return PositionsListByTeam;
    }

    static get UpdatePlayer() {
        return UpdatePlayer;
    }

    static get AddPlayer() {
        return AddPlayer;
    }

    static get DeletePlayer() {
        return DeletePlayer;
    }

    static get GetPlayer() {
        return GetPlayer;
    }

    static get GetFormationList() {
        return FormationList;
    }

    static get AddGamePlan() {
        return AddGamePlan;
    }

    static get GetGamePlans() {
        return GetGamePlanByTeam;
    }

    static get DeleteGamePlans() {
        return DeleteGamePlan;
    }
}