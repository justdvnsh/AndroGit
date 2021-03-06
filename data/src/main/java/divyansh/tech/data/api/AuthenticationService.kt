package divyansh.tech.data.api

import divyansh.tech.data.models.AuthToken
import divyansh.tech.utility.C
import retrofit2.Response
import retrofit2.http.*

/*
* API interface which contains the calls to Authentication Service
* */
interface AuthenticationService {

    /*
    * Provides the interface to get the access token from the access code
    * @param client_id -> Client ID generated from github
    * @param client_secret -> Client SECRET generated from github
    * @param code -> Access Code generated from github
    *
    * @returns Response<AuthToken>
    * */
    @Headers("Accept: application/json", "User-Agent: request")
    @POST
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Url url: String = C.ACCESS_TOKEN_URL,
        @Field("client_id") client_id: String,
        @Field("client_secret") client_secret: String,
        @Field("code") access_code: String
    ): Response<AuthToken>
}