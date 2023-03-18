export class PlayerEditModel {
    constructor(id, name, number, age, img) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.age = age;
        this.img = img;
    }
}

export class PlayerAddModel extends PlayerEditModel {
    constructor(id, name, number, age, img, position, team) {
        super(id, name, number, age, img);
        this.position = position;
        this.team = team;
    }
}