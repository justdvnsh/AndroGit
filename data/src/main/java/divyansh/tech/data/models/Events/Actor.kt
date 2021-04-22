package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Actor(
    @Json(name = "avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/29144058?
    @Json(name = "display_login")
    val displayLogin: String, // justdvnsh
    @Json(name = "gravatar_id")
    val gravatarId: String,
    @Json(name = "id")
    val id: Int, // 29144058
    @Json(name = "login")
    val login: String, // justdvnsh
    @Json(name = "url")
    val url: String // https://api.github.com/users/justdvnsh
)