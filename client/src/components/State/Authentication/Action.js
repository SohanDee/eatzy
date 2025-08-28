import axios from "axios";
import { REGISTER_REQUEST } from "./Reducer";
import { api } from "../../config/api";

export const registerUSer = (reqData) => async(dispatch) => {
    dispatch({type:REGISTER_REQUEST})
    try {
        const {data} = await api.post
    } catch (error) {
        console.log(error);
        
    }
}