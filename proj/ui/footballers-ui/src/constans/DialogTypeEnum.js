export class DialogTypeEnum {
    static Add = new DialogTypeEnum(0);
    static Upd = new DialogTypeEnum(1);
    static Del = new DialogTypeEnum(2);

    constructor(num) {
        this.num = num;
    }
}