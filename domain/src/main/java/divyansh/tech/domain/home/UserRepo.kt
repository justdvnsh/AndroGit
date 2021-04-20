package divyansh.tech.domain.home

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import divyansh.tech.data.api.ProfileService
import divyansh.tech.data.models.User
import divyansh.tech.data.persistence.DataStoreManager
import divyansh.tech.utility.C
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import javax.inject.Inject

/*
* Repository to provide user profile related functions
* @param profileService -> Instance of profile Service
* */
class UserRepo @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val profileService: ProfileService,
) {

    /*
    * Suspend function call to the respected endpoint
    * */
    suspend fun getUserProfile() =
        profileService.getAuthenticatedUser()

    /*
    * Suspend function to Cache the username
    * @param username: String
    * */
    suspend fun cacheUser(username: String) =
        dataStoreManager.setUsername(username)

    /*
    * Retreive the username
    * */
    fun getCachedUser() = dataStoreManager.username
}