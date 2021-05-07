package divyansh.tech.domain.home.feed

import divyansh.tech.data.api.FeedService
import divyansh.tech.utility.ResultWrapper
import javax.inject.Inject

/*
* Fetch remote items for feed
* */
class RemoteFeedRepo @Inject constructor(
    private val feedService: FeedService
) {

    /*
    * Function call to get the events for the authenticated user
    * @param username -> String;
    * */
    suspend fun getEvents(
        username: String
    ): ResultWrapper<*> {
        val response = feedService.getUserEvents(username)
        return if (response.isSuccessful) ResultWrapper.Success(response.body())
        else ResultWrapper.Error(response.message(), null)
    }
}