package divyansh.tech.domain

import divyansh.tech.data.api.AuthenticationService
import divyansh.tech.utility.C
import javax.inject.Inject

/*
* Authentication Repository which gets and saves the access token
* */
class AuthRepo @Inject constructor(
    private val authService: AuthenticationService
) {

    /*
    * Suspend Function to retrieve the Auth Token
    * @param accessCode -> The Access Code returned by Github
    * @returns Job
    * */
   suspend fun getAccessToken(
       accessCode: String
   ) = authService.getAccessToken(
       client_id = C.CLIENT_ID,
       client_secret = C.CLIENT_SECRET,
       access_code = accessCode
   )
}