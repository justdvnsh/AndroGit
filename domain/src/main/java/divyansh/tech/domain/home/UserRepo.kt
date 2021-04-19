package divyansh.tech.domain.home

import divyansh.tech.data.api.ProfileService
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val profileService: ProfileService
) {

    suspend fun getUserProfile() =
        profileService.getAuthenticatedUser()
}