package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Org(
    @Json(name = "avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/47870548?
    @Json(name = "gravatar_id")
    val gravatarId: String,
    @Json(name = "id")
    val id: Int, // 47870548
    @Json(name = "login")
    val login: String, // anitab-org
    @Json(name = "url")
    val url: String // https://api.github.com/orgs/anitab-org
)