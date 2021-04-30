package divyansh.tech.data.api

import divyansh.tech.data.models.PullRequests.Pulls
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/*
* Interface for the PR services
* */
interface PullRequestsService {

    /*
    * Get all the PR's for a user
    * */
    @GET
    suspend fun getPullRequests(
        @Url url: String
    ): Response<Pulls>
}