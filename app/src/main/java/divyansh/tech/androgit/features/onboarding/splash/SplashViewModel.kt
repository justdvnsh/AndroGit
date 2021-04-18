package divyansh.tech.androgit.features.onboarding.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.AuthToken
import divyansh.tech.domain.AuthRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* [VIEWMODEL] for the splash activity
* */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepo: AuthRepo
): ViewModel() {

    private val _accessToken: MutableLiveData<Boolean> = MutableLiveData()
    val accessToken: LiveData<Boolean>
        get() = _accessToken

    fun isUserLoggedIn() = viewModelScope.launch {
        authRepo.fetchAccessToken().single()?.let {
            _accessToken.value = true
            return@launch
        }
        _accessToken.value = false
    }
}