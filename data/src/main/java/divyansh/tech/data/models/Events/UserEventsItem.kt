package divyansh.tech.data.models.Events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class UserEventsItem(
    @Json(name = "actor")
    val actor: Actor,
    @Json(name = "created_at")
    val createdAt: String, // 2021-04-16T16:34:30Z
    @Json(name = "id")
    val id: String, // 15972295928
    @Json(name = "org")
    val org: Org,
    @Json(name = "payload")
    val payload: Payload,
    @Json(name = "public")
    val `public`: Boolean, // true
    @Json(name = "repo")
    val repo: Repo,
    @Json(name = "type")
    val type: String // PushEvent
)