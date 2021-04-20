package divyansh.tech.androgit.features.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.data.models.User
import divyansh.tech.domain.home.UserRepo
import divyansh.tech.utility.ResultWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepo: UserRepo
): ViewModel() {

    private val _user: MutableLiveData<ResultWrapper<User>> = MutableLiveData()
    val user: LiveData<ResultWrapper<User>>
        get() = _user

    fun getUserProfile() = viewModelScope.launch {
        _user.postValue(ResultWrapper.Loading())
        val response = userRepo.getUserProfile()
        if (response.isSuccessful) {
            response.body()?.let {
                _user.postValue(ResultWrapper.Success(it))
                userRepo.cacheUser(it.login)
            }
        } else _user.postValue(ResultWrapper.Error(response.message()))
    }
}