import Enviroment from "../enviroment/Enviroment"

export const Teams = Enviroment.ApiUrl + 'teams'
export const AddTeams = Teams + '/add'
export const DeleteTeams = Teams + '/delete'

export const PlayersByTeam = Enviroment.ApiUrl + 'players'
export const UpdatePlayer = PlayersByTeam + '/update'
export const AddPlayer = PlayersByTeam + '/add'

export const PositionsList = Enviroment.ApiUrl + 'positions'

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

    static get UpdatePlayer() {
        return UpdatePlayer;
    }

    static get AddPlayer() {
        return AddPlayer;
    }
}