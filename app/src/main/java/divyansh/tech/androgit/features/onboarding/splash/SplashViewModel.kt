package divyansh.tech.androgit.features.onboarding.splash

import android.util.Log
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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