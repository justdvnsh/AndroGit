package divyansh.tech.androgit.features.home.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.Events.UserEventsItem
import divyansh.tech.domain.home.FeedRepo
import divyansh.tech.domain.home.UserRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
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
    private val feedRepo: FeedRepo
): ViewModel() {

    private val _events: MutableLiveData<ResultWrapper<List<UserEventsItem>>> = MutableLiveData()
    val events: LiveData<ResultWrapper<List<UserEventsItem>>>
        get() = _events

    /*
    * Function to fetch the events for the authenticated user.
    * @returns Job
    * */
    fun getEvents() = viewModelScope.launch {
        val username = withContext(Dispatchers.IO) {
            userRepo.getCachedUser()
        }.first()
        val response = feedRepo.getEvents(username)
        if (response.isSuccessful) {
            response.body()?.let {
                _events.postValue(ResultWrapper.Success(it))
            }
        } else _events.postValue(ResultWrapper.Error("Something Went wrong !!"))
    }
}