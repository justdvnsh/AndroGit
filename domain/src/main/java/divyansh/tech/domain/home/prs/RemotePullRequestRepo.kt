package divyansh.tech.domain.home.prs

import divyansh.tech.data.api.PullRequestsService
import divyansh.tech.data.models.PullRequests.Pulls
import divyansh.tech.data.persistence.DataStoreManager
import divyansh.tech.utility.C
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.first
import retrofit2.Response
import javax.inject.Inject

class RemotePullRequestRepo @Inject constructor(
    private val pullRequestsService: PullRequestsService,
    private val dataStoreManager: DataStoreManager
) {

    /*
    * Gets all the pulls for a user
    * @param: itemType: C.Type
    * @param sort: String
    * @param state: String
    * @returns Response<Pulls>
    * */
    suspend fun getAllPulls(
        itemType: C.TYPE,
        sort: String = "sort:desc",
        state: String = "state:open"
    ): ResultWrapper<*> {
        val username = dataStoreManager.username.first()
        return when (itemType) {
            C.TYPE.CREATED -> getResponse(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+author:$username+$sort+$state"
            )
            C.TYPE.ASSIGNED -> getResponse(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+assignee:$username+$sort+$state"
            )
            C.TYPE.MENTIONED -> getResponse(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+mentions:$username+$sort+$state"
            )
            C.TYPE.REQUESTED -> getResponse(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+review-requested:$username+$sort+$state"
            )
        }
    }

    /*
    * Util function
    * */
    private suspend fun getResponse(url: String): ResultWrapper<*> {
        val response = pullRequestsService.getPullRequests(url)
        return if (response.isSuccessful) ResultWrapper.Success(response.body())
        else ResultWrapper.Error(response.message(), null)
    }
}