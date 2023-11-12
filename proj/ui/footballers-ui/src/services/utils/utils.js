import LocalStorageConsts from "../../constans/LocalStorageConsts";

export default class Utils {
    static getFileBytes(file) {
        return new Promise(function(resolve, reject) {
            var reader = new FileReader();
            reader.onload = function() { resolve(reader.result); };
            reader.onerror = reject;
            reader.readAsDataURL(file);
        });
    }

    static async sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    static getJwt() {
        return localStorage.getItem(LocalStorageConsts.Token);
    }

    static getLogin() {
        return localStorage.getItem(LocalStorageConsts.Login);

    }
}