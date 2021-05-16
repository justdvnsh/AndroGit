package divyansh.tech.data.api

import divyansh.tech.data.models.issues.IssueItems
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
* API interface which provides issues service endpoints
* */
interface IssueService {

    /*
    * function to provide the issues for the user
    */
    @GET("/user/issues")
    suspend fun fetchIssues(
        @Query("filter") queryString: String,
        @Query("sort") sort: String? = null,
        @Query("state") state: String? = null
    ): Response<IssueItems>
}