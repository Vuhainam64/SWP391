import { fetchUser } from "../components/utils/fetchLocalStorageData"

const userInfo = fetchUser()

export const initalState = {
    user: userInfo,
}