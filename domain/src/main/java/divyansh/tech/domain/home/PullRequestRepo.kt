package divyansh.tech.domain.home

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import divyansh.tech.data.api.PullRequestsService
import divyansh.tech.data.persistence.DataStoreManager
import divyansh.tech.domain.R
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PullRequestRepo @Inject constructor(
    private val pullRequestsService: PullRequestsService,
    private val dataStoreManager: DataStoreManager
) {

    companion object {
        enum class TYPE { ASSIGNED, CREATED, MENTIONED, REQUESTED }
    }

    suspend fun getAllPulls(
        itemString: TYPE,
        sort: String = "sort:desc",
        state: String = "state:open"
    ) {
        val username = dataStoreManager.username.first()
        when (itemString) {
            TYPE.CREATED -> {}
            TYPE.ASSIGNED -> {}
            TYPE.MENTIONED -> {}
            TYPE.REQUESTED -> {}
        }
    }
}