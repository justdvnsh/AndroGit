package divyansh.tech.androgit.features.onboarding.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.domain.onboarding.AuthRepo
import kotlinx.coroutines.flow.first
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

    /*
    * Checks if the user is logged in, ie. if already an access token is present for this user
    * */
    fun isUserLoggedIn() = viewModelScope.launch {
        val st = authRepo.fetchAccessToken().first()
        if (st.isNotEmpty()) _accessToken.postValue(true)
        else _accessToken.postValue(false)
    }
}