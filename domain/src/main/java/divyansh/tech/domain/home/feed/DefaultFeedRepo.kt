package divyansh.tech.domain.home.feed

import divyansh.tech.data.api.FeedService
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*
* [UserRepo] repository for the feed view model
* @param feedService -> Instance of feedService
* */
class DefaultFeedRepo @Inject constructor(
    private val remoteFeedRepo: RemoteFeedRepo,
    private val localFeedRepo: LocalFeedRepo
) {

    /*
    * Function call to get the events for the authenticated user
    * @param username -> String;
    * */
    suspend fun getEvents(
        username: String
    ): Flow<ResultWrapper<*>> {
        return flow {
            // TODO: Add local data first (caching)
            val response = remoteFeedRepo.getEvents(username)
            emit(response)
        }
    }
}