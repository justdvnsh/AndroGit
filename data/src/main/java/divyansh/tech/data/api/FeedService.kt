package divyansh.tech.data.api

import divyansh.tech.data.models.Events.UserEventItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/*
* API interface which call to user events services
* */
interface FeedService {

    /*
    * Provides the interface to get the list of events for an authenticated user
    * @param username -> Username of the authenticated user
    * @returns Response<UserEvents>
    * */
    @GET("/users/{username}/events")
    suspend fun getUserEvents(
        @Path("username") username: String
    ): Response<List<UserEventItem>>

}