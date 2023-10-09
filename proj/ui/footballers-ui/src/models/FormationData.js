export class FormationData {
    constructor(formationArray) {
        this.length = formationArray.length;
        this.playersArray = [[0]];
        for (let i = 0; i < formationArray.length; i++) { 
            this.playersArray.push(this.constructArrayArea(formationArray[i]));
        }
    }

    constructArrayArea(amount) {
        let resArray = [];
        for (let i = 0; i < amount; i++) { 
            resArray.push(0);
        }
        return resArray;
    }
}