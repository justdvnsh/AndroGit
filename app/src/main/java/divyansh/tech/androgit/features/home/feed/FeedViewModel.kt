package divyansh.tech.androgit.features.home.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.events.UserEventItem
import divyansh.tech.domain.home.feed.DefaultFeedRepo
import divyansh.tech.domain.home.profile.UserRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
* [ViewModel] for the Feed Fragment
* */
@HiltViewModel
class FeedViewModel @Inject constructor(
    private val userRepo: UserRepo,
    private val feedRepo: DefaultFeedRepo
): ViewModel() {

    private val _events: MutableLiveData<ResultWrapper<List<UserEventItem>>> = MutableLiveData()
    val events: LiveData<ResultWrapper<List<UserEventItem>>>
        get() = _events

    /*
    * Function to fetch the events for the authenticated user.
    * @returns Job
    * */
    fun getEvents() = viewModelScope.launch {
        _events.postValue(ResultWrapper.Loading())
        val username = withContext(Dispatchers.IO) {
            userRepo.getCachedUser()
        }.first()
        val response = feedRepo.getEvents(username)
        response.collect {
            when (it) {
                is ResultWrapper.Success -> _events.postValue(
                    ResultWrapper.Success(it.data as List<UserEventItem>)
                )
                is ResultWrapper.Error -> _events.postValue(
                    ResultWrapper.Error(it.message.toString())
                )
            }
        }
    }
}