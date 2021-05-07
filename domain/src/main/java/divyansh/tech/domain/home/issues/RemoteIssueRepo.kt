package divyansh.tech.domain.home.issues

import divyansh.tech.data.api.IssueService
import divyansh.tech.utility.ResultWrapper
import javax.inject.Inject

/*
* Repo to fetch issues remotely
* */
class RemoteIssueRepo @Inject constructor(
    private val issueService: IssueService
) {

    /*
    * Fetch issues remotely
    * @param queryString: String,
    * @param sort: String
    * @param status: String
    * @returns ResultWrapper<*>
    * */
    suspend fun fetchIssues(
        queryString: String,
        sort: String? = null,
        state: String? = null
    ): ResultWrapper<*> {
        val response = issueService.fetchIssues(queryString, sort, state)
        return if (response.isSuccessful) ResultWrapper.Success(response.body())
        else ResultWrapper.Error(response.message(), null)
    }
}