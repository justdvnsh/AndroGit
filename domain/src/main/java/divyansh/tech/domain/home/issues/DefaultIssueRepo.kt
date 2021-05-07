package divyansh.tech.domain.home.issues

import divyansh.tech.data.api.IssueService
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultIssueRepo @Inject constructor(
    private val remoteIssueRepo: RemoteIssueRepo,
    private val localIssueRepo: LocalIssueRepo
){

    suspend fun fetchIssues(
        queryString: String,
        sort: String? = null,
        status: String? = null
    ): Flow<ResultWrapper<*>> {
        return flow {
            //TODO: Add local data first
            val response = remoteIssueRepo.fetchIssues(queryString, sort, status)
            emit(response)
        }
    }
}