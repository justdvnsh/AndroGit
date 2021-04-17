package divyansh.tech.androgit.features.onboarding.auth

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.AuthToken
import divyansh.tech.domain.AuthRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* Login View Model -> Coroutine implementations of auth functions
* */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepo: AuthRepo
): ViewModel() {

    private val _status: MutableLiveData<ResultWrapper<Boolean>> = MutableLiveData()
    val status: LiveData<ResultWrapper<Boolean>>
        get() = _status

    fun authorizeUser(accessCode: String) = viewModelScope.launch {
        _status.value = ResultWrapper.Loading()
        authRepo.getAccessToken(accessCode)
    }
}