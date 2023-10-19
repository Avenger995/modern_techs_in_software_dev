export class GamePlansModel {
    constructor(id, formation, name, team, array) {
        this.id = id;
        this.formation = formation;
        this.name = name;
        this.team = team;
        this.array = JSON.stringify(array);
    }
}