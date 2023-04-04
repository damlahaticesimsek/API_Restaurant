import api from './index'

export const getAllFoods = async () => {
    const response = await api.get('/menu/1/getMenu')
    // console.log(response.data)
    return response.data
}

export const getAllCategories = async () => {
    const response = await api.get('/menu/1/getCategories')
    // console.log(response.data)
    return response.data
}