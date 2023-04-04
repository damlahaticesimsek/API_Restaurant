import { S3Api } from './index'

export const getImageFromS3 = async (path) => {
    const response = await S3Api.get(path)
    return Buffer.from(response.data, "binary").toString("base64");
}