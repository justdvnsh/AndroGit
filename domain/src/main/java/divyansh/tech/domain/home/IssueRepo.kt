package divyansh.tech.domain.home

import divyansh.tech.data.api.IssueService
import javax.inject.Inject

class IssueRepo @Inject constructor(
    private val issueService: IssueService
){

    suspend fun fetchIssues(
        queryString: String,
        sort: String? = null,
        state: String? = null
    ) = issueService.fetchIssues(queryString, sort, state)
}