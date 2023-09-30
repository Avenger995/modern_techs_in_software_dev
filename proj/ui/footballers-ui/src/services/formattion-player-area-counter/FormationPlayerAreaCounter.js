
export default class FormationPlayerAreaCounter {

    static fullPitchValue = 0.5;
    static oneHundred = 100;
    static centerPitchValue = 40;
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
        return (this.centerPitchValue / amount).toFixed() + '%';
    }

    static readFormation(formation) {

    }
}