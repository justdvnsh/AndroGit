package divyansh.tech.domain.home

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import divyansh.tech.data.api.PullRequestsService
import divyansh.tech.data.models.PullRequests.Pulls
import divyansh.tech.data.persistence.DataStoreManager
import divyansh.tech.domain.R
import divyansh.tech.utility.C
import kotlinx.coroutines.flow.first
import retrofit2.Response
import javax.inject.Inject

/*
* Repo for PR's
* */
class PullRequestRepo @Inject constructor(
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
    ): Response<Pulls> {
        val username = dataStoreManager.username.first()
        return when (itemType) {
            C.TYPE.CREATED -> pullRequestsService.getPullRequests(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+author:$username+$sort+$state"
            )
            C.TYPE.ASSIGNED -> pullRequestsService.getPullRequests(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+assignee:$username+$sort+$state"
            )
            C.TYPE.MENTIONED -> pullRequestsService.getPullRequests(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+mentions:$username+$sort+$state"
            )
            C.TYPE.REQUESTED -> pullRequestsService.getPullRequests(
                url = "https://api.github.com/search/issues?q=type:pr+is:pr+review-requested:$username+$sort+$state"
            )
        }
    }
}