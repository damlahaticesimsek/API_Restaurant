import {postApi} from './index';

export const addOrder = async (data) => {
    const response = await postApi.post('/order/1/addOrder', data)
    // console.log(response.data)
    return response.data
}
