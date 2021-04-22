package divyansh.tech.domain.home

import divyansh.tech.data.api.FeedService
import javax.inject.Inject

/*
* [UserRepo] repository for the feed view model
* @param feedService -> Instance of feedService
* */
class FeedRepo @Inject constructor(
    private val feedService: FeedService
) {

    /*
    * Function call to get the events for the authenticated user
    * @param username -> String;
    * */
    suspend fun getEvents(
        username: String
    ) = feedService.getUserEvents(username)
}