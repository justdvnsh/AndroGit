package divyansh.tech.utility

object C {

    /*
    * Retrofit constants
    * */
    const val BASE_URL: String = "https://api.github.com/"
    const val OAUTH_URL = "https://github.com/login/oauth/authorize/"
    const val ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token"
    const val CLIENT_ID = "4706c565144ae239b745"
    const val CLIENT_SECRET = "3e0976a34ac8ec1bd7f01616cc822420d1394e7e"
    const val OAUTH_REDIRECT_URL = "github://oauthcallback"

    /*
    * Data Constants
    * */
    const val USER_PREF_FILENAME = "settings"

    /*
    * USER CONSTANTS
    * */
    const val USER_CACHE_FILENAME = "user_profile"

    /*
    * PR Types
    * */
    enum class TYPE { ASSIGNED, CREATED, MENTIONED, REQUESTED }
}