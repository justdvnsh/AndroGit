package divyansh.tech.domain.home.prs

import divyansh.tech.utility.C
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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