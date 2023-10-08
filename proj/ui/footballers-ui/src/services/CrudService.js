import axios from "axios"
import ApiPath from "../constans/ApiPath";


export default class CrudService {
    
    static async getAll(url) {
        const response = await axios.get(String(url));
        return response;
    }

    static async getById(url, id) {
        const response = await axios.get(String(url) + `/${id}`);
        return response;
    }

    static async getAllByTeam(url) {
        const response = await axios.get(String(url));
        return response;
    }

    static async add(url, obj) {
        const response = await axios.post(String(url), obj, {
            headers: ApiPath.Headers
        });
        return response;
    }

    static async deleteById(url, id) {
        const response = await axios.delete(String(url) + `/${id}`);
        return response;
    }

    static async update(url, obj) {
        const response = await axios.put((String)(url), obj, {
            headers: ApiPath.Headers
        });
        return response;
    }
}