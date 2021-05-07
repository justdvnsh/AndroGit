package divyansh.tech.androgit.features.home.issues

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.Issues.Issue
import divyansh.tech.domain.home.issues.DefaultIssueRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssueItemViewModel @Inject constructor(
    private val issueRepo: DefaultIssueRepo
): ViewModel() {

    private val _issues: MutableLiveData<ResultWrapper<List<Issue>>> = MutableLiveData()
    val issues: LiveData<ResultWrapper<List<Issue>>> = _issues

    fun fetchIssues(
        queryString: String,
        sort: String? = null,
        status: String? = null
    ) = viewModelScope.launch(Dispatchers.IO) {
        _issues.postValue(ResultWrapper.Loading())
        val response = issueRepo.fetchIssues(queryString, sort, status)
        response.collect {
            when (it) {
                is ResultWrapper.Success ->
                    _issues.postValue(ResultWrapper.Success(it.data as List<Issue>))
                is ResultWrapper.Error ->
                    _issues.postValue(ResultWrapper.Error(it.message.toString()))
                else -> {}
            }
        }
    }
}