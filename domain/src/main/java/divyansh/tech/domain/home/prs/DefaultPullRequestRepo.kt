package divyansh.tech.domain.home.prs

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import divyansh.tech.data.api.PullRequestsService
import divyansh.tech.data.models.PullRequests.Pulls
import divyansh.tech.data.persistence.DataStoreManager
import divyansh.tech.domain.R
import divyansh.tech.utility.C
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

/*
* Repo for PR's
* */
class DefaultPullRequestRepo @Inject constructor(
    private val remotePullRequestRepo: RemotePullRequestRepo,
    private val localPullRequestRepo: LocalPullRequestRepo
) {

    suspend fun getAllPulls(
        itemType: C.TYPE,
        sort: String = "sort:desc",
        state: String = "state:open"
    ): Flow<ResultWrapper<*>> {
        return flow {
            // TODO: Add local data first
            val response = remotePullRequestRepo.getAllPulls(itemType, sort, state)
            emit(response)
        }
    }
}