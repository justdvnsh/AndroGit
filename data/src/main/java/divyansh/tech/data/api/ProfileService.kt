package divyansh.tech.data.api

import divyansh.tech.data.models.Users.User
import retrofit2.Response
import retrofit2.http.GET

/*
* API interface which call to user services
* */
interface ProfileService {

    /*
    * Suspend function to get the authenticated User details
    * @returns Response<User>
    * */
    @GET("/user")
    suspend fun getAuthenticatedUser(): Response<User>
}