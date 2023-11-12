export class GamePlansModel {
    constructor(id, formation, name, team, array, owner) {
        this.id = id;
        this.formation = formation;
        this.name = name;
        this.team = team;
        this.array = JSON.stringify(array);
        this.dtCreation = new Date();
        this.owner = owner;
    }
}