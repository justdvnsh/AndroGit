package divyansh.tech.androgit.features.home.issues

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.Issues.Issue
import divyansh.tech.domain.home.IssueRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssueItemViewModel @Inject constructor(
    private val issueRepo: IssueRepo
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
        Log.i("ISSUE ___", Gson().toJson(response))
        if (response.isSuccessful) {
            response.body()?.let {
                Log.i("ISSUE", it.toString())
                _issues.postValue(ResultWrapper.Success(it))
            }
        } else _issues.postValue(ResultWrapper.Error(response.message()))
    }
}