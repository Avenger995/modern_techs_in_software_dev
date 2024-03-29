import Enviroment from "../enviroment/Enviroment";
import Utils from "../services/utils/utils";

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

export const Login = Enviroment.ApiUrl + 'auth/login'

export const Headers = {'Authorization': `Bearer ${Utils.getJwt()}`,
    'Accept': 'application/json',
    'Content-Type': 'application/json'};

export const HeadersLogin = {'Accept': 'application/json',
'Content-Type': 'application/json'};

export const HeadersUsual = {'Authorization': `Bearer ${Utils.getJwt()}`};

export default class ApiPath {
    static get Headers() {
        return Headers;
    }

    static get HeadersLogin() {
        return HeadersLogin;
    }

    static get HeadersUsual() {
        return HeadersUsual;
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

    static get Login() {
        return Login;
    }
}