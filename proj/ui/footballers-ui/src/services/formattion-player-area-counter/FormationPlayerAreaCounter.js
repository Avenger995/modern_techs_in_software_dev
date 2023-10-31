import { FormationData } from "../../models/FormationData";

export default class FormationPlayerAreaCounter {

    static fullPitchValue = 0.5;
    static oneHundred = 100;
    static centerPitchValue = 60;
    static maxLeft = 10; 

    static getFormationPlayerAreaData(position, length, amount) {
        let left = this.getLeftValue(position, length);
        let top = this.getTopValue(amount);
        return {
            '--left': left,
            '--top': top
        };
    }

    static getLeftValue(position, length) {
        return (this.fullPitchValue * position / 
            length * this.oneHundred + this.maxLeft).toFixed(0) + '%';
    }

    static getTopValue(amount) {
        if (amount === 1) return '40%';
        return (this.centerPitchValue / amount).toFixed() + '%';
    }

    static readFormation(formation) {
        return new FormationData(formation.split('-'));
    }

    static updateFormationData(initFormationData, area, position, playerId) {
        initFormationData.playersArray[area][position] = playerId;
        return initFormationData;
    }

    static setFormationData(arrayString) {
        return {'playersArray': JSON.parse(arrayString)};
    }

    static isPlayerDisabledToChoose(formationData, playerId) {
        for (let i = 0; i < formationData.length; i++) { 
            if (formationData[i].includes(playerId)) 
                return true;
        }
        return false;
    }
}