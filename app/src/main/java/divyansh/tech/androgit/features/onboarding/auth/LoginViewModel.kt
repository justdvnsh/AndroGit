package divyansh.tech.androgit.features.onboarding.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.AuthToken
import divyansh.tech.domain.onboarding.AuthRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
* Login View Model -> Coroutine implementations of auth functions
* */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepo
): ViewModel() {

    private val _status: MutableLiveData<ResultWrapper<AuthToken>> = MutableLiveData()
    val status: LiveData<ResultWrapper<AuthToken>>
        get() = _status

    /*
    * Function to launch the authorization process. First retrieve the access token
    * Then save the token securely to the disk
    * @param accessCode -> The code retrieved from Github
    * */
    fun authorizeUser(accessCode: String) = viewModelScope.launch {
        _status.value = ResultWrapper.Loading()
        val response = authRepo.getAccessToken(accessCode)
        Log.i("VIEWMODEL", response.raw().toString())
        if (response.isSuccessful) {
            response.body()?.let {
                withContext(Dispatchers.IO) {
                    Log.i("VIEWMODEL", it.access_token)
                    authRepo.saveAccessToken(it.access_token)
                    _status.postValue(ResultWrapper.Success(it))
                }
            }
        } else {
            Log.i("VIEWMODEL", response.message())
            _status.postValue(ResultWrapper.Error(response.message()))
        }
    }
}