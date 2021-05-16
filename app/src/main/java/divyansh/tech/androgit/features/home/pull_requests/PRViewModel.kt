package divyansh.tech.androgit.features.home.pull_requests

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.pullRequests.Pulls
import divyansh.tech.domain.home.prs.DefaultPullRequestRepo
import divyansh.tech.utility.C
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* Pull Request ViewModel
* */
@HiltViewModel
class PRViewModel @Inject constructor(
    private val prRepo: DefaultPullRequestRepo
): ViewModel() {

    private val _pullRequests: MutableLiveData<ResultWrapper<Pulls>> = MutableLiveData()
    val pullRequests: LiveData<ResultWrapper<Pulls>> = _pullRequests

    /*
    * Function to launch the function to getAll prs for a user on a background thread
    * @param: itemType: C.TYPE
    * */
    fun getAllPRs(itemType: C.TYPE) = viewModelScope.launch(Dispatchers.IO) {
        _pullRequests.postValue(ResultWrapper.Loading())
        val response = prRepo.getAllPulls(itemType)
        response.collect {
            when (it) {
                is ResultWrapper.Success ->
                    _pullRequests.postValue(ResultWrapper.Success(it.data as Pulls))
                is ResultWrapper.Error ->
                    _pullRequests.postValue(ResultWrapper.Error(it.message.toString()))
                else -> {}
            }
        }
    }
}