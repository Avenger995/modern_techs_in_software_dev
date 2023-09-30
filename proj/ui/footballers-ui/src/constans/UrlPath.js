
export const Teams = '/teams'
export const Players = '/players'
export const Formations = '/formations'

export default class UrlPath {

    static get Teams() {
        return Teams;
    } 

    static get Players() {
        return Players;
    }

    static get Formations() {
        return Formations;
    }
}